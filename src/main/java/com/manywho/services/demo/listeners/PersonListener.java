package com.manywho.services.demo.listeners;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ListenerServiceResponse;
import com.manywho.sdk.services.identity.AuthorizationEncoder;
import com.manywho.sdk.services.listeners.Listener;
import com.manywho.sdk.services.listeners.ListenerData;
import com.manywho.services.demo.ApplicationConfiguration;
import com.manywho.services.demo.types.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Listener.Metadata(event = "Person")
public class PersonListener implements Listener<ApplicationConfiguration, Person> {

    Logger LOGGER = LoggerFactory.getLogger(PersonListener.class);

    @Inject
    private AuthorizationEncoder authorizationEncoder;

    @Override
    public void create(ApplicationConfiguration configuration, Person person, ListenerData listenerData) {

        LOGGER.debug("PersonListener.create( listenerData.request.valueForListening.valueElementId=" + listenerData.getRequest().getValueForListening().getValueElementId() + " )");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {

            try {
                ListenerServiceResponse response = new ListenerServiceResponse();
                response.setTenantId(listenerData.getAuthenticatedWho().getManyWhoTenantId());
                response.setToken(listenerData.getRequest().getToken());
                response.setCulture(listenerData.getRequest().getCulture());

                EngineValue valueForListening = listenerData.getRequest().getValueForListening();
                simulateModifyingPersonObject(valueForListening);
                response.setListeningEventValue(valueForListening);

                //make a response to the engine
                makeEventCallback(listenerData, response);

            } catch (Exception e) {
                LOGGER.error("Exception thrown while preparing or sending /event request to the Engine", e);
            }
        });
    }

    private void simulateModifyingPersonObject(EngineValue valueForListening) {

        if(valueForListening.getObjectData() != null
                && valueForListening.getObjectData().get(0) != null
                && valueForListening.getObjectData().get(0).getProperties() != null) {

            valueForListening.getObjectData().get(0).getProperties().stream()
                    .filter(property -> "Name".equals(property.getDeveloperName()))
                    .findFirst()
                    .ifPresent(property -> property.setContentValue((property.getContentValue() != null ? property.getContentValue() : "") + " - modified at " + Instant.now()));
        }
    }

    private void makeEventCallback(ListenerData listenerData, ListenerServiceResponse response) throws IOException {
        String authorizationHeader = authorizationEncoder.encode(listenerData.getAuthenticatedWho());

        //removing the "/event" from the end of the callback uri, because then Retrofit will add it automatically - see EngineClient interface
        //sadly, don't know a better way to do it that works with Retrofit - it will not accept @POST("")
        String baseUri = listenerData.getRequest().getCallbackUri().replaceFirst("/event$", "");

        InvokeType invokeType = createEngineClient(baseUri)
                    .event(authorizationHeader, listenerData.getRequest().getTenantId(), response)
                    .execute()
                    .body();

        LOGGER.debug("Successfully sent the /event request to the Engine. Received invokeType=" + invokeType);
    }

    private EngineClient createEngineClient(String callbackUri) {

        if(!callbackUri.endsWith("/")) {
            callbackUri = callbackUri + "/";
        }

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapperFactory.create()))
                .baseUrl(callbackUri)
                .build();

        return retrofit.create(EngineClient.class);
    }

    @Override
    public void createMultiple(ApplicationConfiguration configuration, List<Person> list, ListenerData listenerData) {

    }
}

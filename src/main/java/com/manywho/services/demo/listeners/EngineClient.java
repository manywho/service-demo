package com.manywho.services.demo.listeners;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.config.ListenerServiceResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import java.util.UUID;

public interface EngineClient {

    @POST("event")
    Call<InvokeType> event(
            @Header("Authorization") String authorization,
            @Header("ManyWhoTenant") UUID tenant,
            @Body ListenerServiceResponse response
    );
}

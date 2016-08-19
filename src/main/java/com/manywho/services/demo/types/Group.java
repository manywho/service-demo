package com.manywho.services.demo.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Group")
public class Group implements Type {

    @Type.Identifier
    private String id;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

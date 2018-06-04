package com.manywho.services.demo.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.sql.Timestamp;
import java.util.List;

@Type.Element(name = "Person", summary = "A description of a person")
public class Person implements Type {

    @Type.Identifier
    @Type.Property(name = "ID", contentType = ContentType.String)
    private String id;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "Biography", contentType = ContentType.Content)
    private String biography;

    @Type.Property(name = "Age", contentType = ContentType.Number)
    private Integer age;

    @Type.Property(name = "Password", contentType = ContentType.Password)
    private String password;

    @Type.Property(name = "Social Security Number", contentType = ContentType.Encrypted)
    private String socialSecurityNumber;

    @Type.Property(name = "Groups", contentType = ContentType.List)
    private List<Group> groups;

    @Type.Property(name = "Is Active?", contentType = ContentType.Boolean)
    private boolean active;

    @Type.Property(name = "Created At", contentType = ContentType.DateTime)
    private Timestamp createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
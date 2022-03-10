package edu.uc.inventorymanager.dto;

import lombok.Data;

public @Data class User {
    private int id;
    private String username;

    @SerializedName("gender")
    private String gender;
    @SerializedName("name")
    private Name name;
    @SerializedName("location")
    private Location location;
    @SerializedName("email")
    private String email;
    @SerializedName("login")
    private Login login;
    @SerializedName("dob")
    private Dob dob;
    @SerializedName("registered")
    private Registered registered;
    @SerializedName("phone")
    private String phone;
    @SerializedName("cell")
    private String cell;
    @SerializedName("id")
    private Id id;
    @SerializedName("picture")
    private Picture picture;
    @SerializedName("nat")
    private String nat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}

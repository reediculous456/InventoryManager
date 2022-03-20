package edu.uc.inventorymanager.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class User {

    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
    @SerializedName("email")
    private String email;
    @SerializedName("cell")
    private Integer id;
}

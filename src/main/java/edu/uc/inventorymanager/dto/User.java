package edu.uc.inventorymanager.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class User {

    @SerializedName("id")
    private String id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
}

package edu.uc.inventorymanager.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class User {

    @SerializedName("id")
    private String id;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("surname")
    private String surname;
}

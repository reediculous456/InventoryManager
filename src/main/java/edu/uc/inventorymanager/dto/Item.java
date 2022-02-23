package edu.uc.inventorymanager.dto;

import lombok.Data;

public @Data class Item {
    private int id;
    private String itemName;
    private String description;
    private String location;
    private int assigned_to;
    private int status_id;
}

package edu.uc.inventorymanager.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data class Item {
    @NonNull private int itemId;
    private String itemName;
    @NonNull private String description;
    private String location;
    private int assignedTo;
    private int statusId;
}

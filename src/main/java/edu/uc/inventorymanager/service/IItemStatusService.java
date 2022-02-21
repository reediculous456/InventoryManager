package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.ItemStatus;

import java.util.List;

public interface IItemStatusService {

    void save(ItemStatus itemStatus);

    List<ItemStatus> fetchALl();

    ItemStatus fetchItemStatusById(int i);
}

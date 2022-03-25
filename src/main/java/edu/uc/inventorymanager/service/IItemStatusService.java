package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.ItemStatus;

import java.util.List;

public interface IItemStatusService {

    ItemStatus save(ItemStatus itemStatus) throws Exception;

    List<ItemStatus> fetchALl();

    ItemStatus fetchItemStatusById(int i);
}

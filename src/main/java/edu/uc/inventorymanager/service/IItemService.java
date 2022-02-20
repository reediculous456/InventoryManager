package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.Item;

import java.util.List;

public interface IItemService {
    Item save(Item item) throws Exception;

    List<Item> fetchALl();

    Item fetch(int id);

    void assign(int userId);
}

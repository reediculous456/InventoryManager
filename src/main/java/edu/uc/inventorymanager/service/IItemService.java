package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.Item;

import java.util.List;

public interface IItemService {
    Item save(Item item) throws Exception;

    List<Item> fetchALl();

    Item fetch(int id);

    Item assign(int userId);

    void assign(int userId);

    Item fetchItemById(int id);
}

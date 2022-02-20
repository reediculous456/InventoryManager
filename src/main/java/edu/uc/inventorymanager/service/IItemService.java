package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.Item;

import java.util.List;

public interface IItemService {
    void save(Item item);

    List<Item> fetchALl();

    void assign(int userId);

    Item fetchItemById(int id);
}

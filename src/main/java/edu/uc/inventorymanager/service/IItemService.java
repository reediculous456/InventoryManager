package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.Item;

import java.util.List;

public interface IItemService {
    /**
     * Save a item with a given ID.
     * @param id a unique identifier for a item.
     * @param item a unique instance of the class Item dto.
     * @param userId a unique identifier for assigning item to an user.
     * @return the matching specfic matiching item if not null.
     */

    Item save(Item item) throws Exception;

    List<Item> fetchAll();

    Item assign(int userId);

    Item fetchItemById(int id);
}

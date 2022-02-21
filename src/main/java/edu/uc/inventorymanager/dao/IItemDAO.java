package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;

import java.util.List;


public interface IItemDAO {
    Item save(Item item) throws Exception;

    List<Item> fetchAll();

    Item fetch(int id);
}
//
package edu.uc.inventorymanager.service;


import edu.uc.inventorymanager.dao.IItemDAO;
import edu.uc.inventorymanager.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceStub implements IItemService {

    @Autowired
    private IItemDAO itemDAO;

    public ItemServiceStub() {

    }

    @Override
    public Item save(Item item) throws Exception {
        return itemDAO.save(item);
    }

    @Override
    public List<Item> fetchAll() {
        return itemDAO.fetchAll();
    }

    @Override
    public Item assign(int userId) {
        return null;
    }

    @Override
    public Item fetchItemById(int itemId) {
        Item item = new Item(itemId, "Test Description");
        return item;
    }
}

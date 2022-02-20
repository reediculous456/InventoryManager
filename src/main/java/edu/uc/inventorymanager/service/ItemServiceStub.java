package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceStub implements IItemService {
    @Override
    public void save(Item item) {

    }

    @Override
    public List<Item> fetchALl() {
        return null;
    }

    @Override
    public Item fetchItemById(int id) {
        Item item = new Item();
        item.setDescription("Test Description");
        item.setId(id);
        return item;
    }

    @Override
    public void assign(int userId) {

    }
}

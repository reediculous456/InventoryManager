package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class ItemDAOStub implements IItemDAO {

    List<Item> allItems = new ArrayList<Item>();

    @Override
    public Item save(Item item) throws Exception {
        allItems.add(item);
        return item;
    }

    @Override
    public List<Item> fetchAll() {
        return allItems;
    }

    @Override
    public Item fetchById(int id) {
        return allItems.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Item item = this.fetchById(id);
        allItems.remove(item);
    }
}

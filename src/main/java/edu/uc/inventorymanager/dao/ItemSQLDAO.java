package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class ItemSQLDAO implements IItemDAO {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item save(Item item) throws Exception {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> fetchAll() {
        List<Item> allItems = new ArrayList<>();
        Iterable<Item> items = itemRepository.findAll();
        for (Item item : items) {
            allItems.add(item);
        }
        return allItems;
    }

    @Override
    public Item fetchById(int id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }
}

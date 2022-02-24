package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
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
        return null;
    }
}
//
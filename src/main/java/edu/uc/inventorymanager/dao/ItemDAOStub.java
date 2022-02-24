package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import lombok.Builder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ItemDAOStub implements IItemDAO {

    Map<Integer, Item> allItems = new HashMap<>();

    @Override
    public Item save(Item item) throws Exception{
        Integer id = item.getId();
        allItems.put(id, item);
        return item;
    }
    //If breaks this was here:
    /*
    List<Item> allItems = new ArrayList<Item>();
    @Override
    public Item save(Item item) throws Exception {
        allItems.add(item);
        return item;
    }
     */

    @Override
    public List<Item> fetchAll() {
        List<Item> returnItem = new ArrayList(allItems.values());
        return (List<Item>) allItems;
    }


    @Override
    public Item fetchById(int id) {
        return null;
    }
}
//
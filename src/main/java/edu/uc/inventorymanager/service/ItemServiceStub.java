package edu.uc.inventorymanager.service;


import edu.uc.inventorymanager.dao.IItemDAO;
import edu.uc.inventorymanager.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceStub implements IItemService{

    @Autowired
    private IItemDAO itemDAO;

    public ItemServiceStub(){

    }

    @Override
    public Item save(Item item) throws Exception {
        return itemDAO.save(item);

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

        return itemDAO.fetchAll();
    }

    @Override
    public Item fetch(int id) {
        Item foundItem = itemDAO.fetch(id);
        return foundItem;
    }

    @Override
    public Item assign(int userId) {
    return null;
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

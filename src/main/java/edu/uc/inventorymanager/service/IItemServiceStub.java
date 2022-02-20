package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IItemServiceStub implements IItemService{
    @Override
    public void save(Item item) {

    }

    @Override
    public List<Item> fetchALl() {
        return null;
    }

    @Override
    public Item fetch(int id) {
        return null;
    }

    @Override
    public void assign(int userId) {

    }
}

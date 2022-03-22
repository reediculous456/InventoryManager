package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.ItemStatus;

import java.util.List;

public interface IItemStatusDAO {
    ItemStatus save(ItemStatus status) throws Exception;

    List<ItemStatus> fetchAll();

    ItemStatus fetchById(int id);

    void deleteById(int id);
}

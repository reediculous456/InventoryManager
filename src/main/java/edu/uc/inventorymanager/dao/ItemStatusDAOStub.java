package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.ItemStatus;

import java.util.ArrayList;
import java.util.List;

public class ItemStatusDAOStub implements IItemStatusDAO {
    List<ItemStatus> allItemStatuses = new ArrayList<ItemStatus>();

    @Override
    public ItemStatus save(ItemStatus itemStatus) throws Exception {
        allItemStatuses.add(itemStatus);
        return itemStatus;
    }

    @Override
    public List<ItemStatus> fetchAll() {
        return allItemStatuses;
    }

    @Override
    public ItemStatus fetchById(int id) {
        return allItemStatuses.stream()
                .filter(status -> status.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        ItemStatus itemStatus = this.fetchById(id);
        allItemStatuses.remove(itemStatus);
    }
}

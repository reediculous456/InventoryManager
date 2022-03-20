package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.ItemStatus;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile("test")
@Repository
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

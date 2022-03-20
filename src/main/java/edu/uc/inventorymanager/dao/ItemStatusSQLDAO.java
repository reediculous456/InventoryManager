package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class ItemStatusSQLDAO implements IItemStatusDAO {
    @Autowired
    ItemStatusRepository itemStatusRepository;

    @Override
    public ItemStatus save(ItemStatus itemStatus) throws Exception {
        return itemStatusRepository.save(itemStatus);
    }

    @Override
    public List<ItemStatus> fetchAll() {
        List<ItemStatus> allItemStatuses = new ArrayList<>();
        Iterable<ItemStatus> itemStatuses = itemStatusRepository.findAll();
        for (ItemStatus itemStatus : itemStatuses) {
            allItemStatuses.add(itemStatus);
        }
        return allItemStatuses;
    }

    @Override
    public ItemStatus fetchById(int id) {
        return itemStatusRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        itemStatusRepository.deleteById(id);
    }
}

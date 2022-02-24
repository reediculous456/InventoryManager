package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.ItemStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemStatusServiceStub implements IItemStatusService {

    @Override
    public void save(ItemStatus itemStatus) {

    }

    @Override
    public List<ItemStatus> fetchALl() {
        return null;
    }

    @Override
    public ItemStatus fetchItemStatusById(int id) {
        ItemStatus itemStatus = new ItemStatus();
        itemStatus.setName("Test Name");
        itemStatus.setId(id);
        return itemStatus;
    }//
}

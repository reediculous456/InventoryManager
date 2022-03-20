package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dao.IItemStatusDAO;
import edu.uc.inventorymanager.dto.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemStatusService implements IItemStatusService {

    @Autowired
    private IItemStatusDAO itemStatusDAO;

    @Override
    public ItemStatus save(ItemStatus itemStatus) throws Exception {
        return itemStatusDAO.save(itemStatus);
    }

    @Override
    public List<ItemStatus> fetchALl() {
        return itemStatusDAO.fetchAll();
    }

    @Override
    public ItemStatus fetchItemStatusById(int id) {
        return itemStatusDAO.fetchById(id);
    }
}

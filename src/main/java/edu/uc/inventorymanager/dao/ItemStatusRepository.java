package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.ItemStatus;
import org.springframework.data.repository.CrudRepository;

public interface ItemStatusRepository extends CrudRepository<ItemStatus, Integer> {
}

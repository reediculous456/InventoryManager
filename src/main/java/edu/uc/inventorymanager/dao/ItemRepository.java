package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}

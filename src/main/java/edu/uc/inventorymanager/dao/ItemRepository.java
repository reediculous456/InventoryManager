package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface ItemRepository extends CrudRepository<Item, Integer> {
}

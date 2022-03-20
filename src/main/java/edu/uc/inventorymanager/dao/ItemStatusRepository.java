package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.ItemStatus;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface ItemStatusRepository extends CrudRepository<ItemStatus, Integer> {
}

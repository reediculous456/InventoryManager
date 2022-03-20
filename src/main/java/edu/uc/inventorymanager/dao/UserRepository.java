package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>  {
}

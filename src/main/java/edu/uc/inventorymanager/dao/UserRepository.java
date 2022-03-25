package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface UserRepository extends CrudRepository<User, Integer> {
}

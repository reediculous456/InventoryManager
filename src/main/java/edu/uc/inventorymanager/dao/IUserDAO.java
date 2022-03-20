package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;

import java.io.IOException;
import java.util.List;

public interface IUserDAO {
    User save(User user) throws Exception;

    List<User> fetchAll();

    List<User> fetchUsers(String id) throws IOException;
}

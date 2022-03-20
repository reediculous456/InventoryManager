package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;

import java.io.IOException;
import java.util.List;

public interface IUserService {
    User save(User user) throws Exception;

    List<User> fetchALl();

    User fetchUserById(int id);

    List<User> fetchUsers(String id) throws IOException;
}

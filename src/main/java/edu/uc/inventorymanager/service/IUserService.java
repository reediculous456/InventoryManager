package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;

import java.util.List;

public interface IUserService {
    User save(User user) throws Exception;

    List<User> fetchAll();

    User fetchUserById(int id);
}

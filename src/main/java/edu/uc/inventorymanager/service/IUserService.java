package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    List<User> fetchALl();

    User fetchUserById(int id);
}

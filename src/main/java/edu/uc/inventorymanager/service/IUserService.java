package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;

import java.util.List;

public interface IUserService {
    User save(User user) throws Exception;

    List<User> fetchALl();

    User fetchUserById(int id);
}
//
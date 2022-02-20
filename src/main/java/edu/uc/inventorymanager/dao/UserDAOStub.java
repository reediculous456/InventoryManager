package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.Item;
import edu.uc.inventorymanager.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOStub implements IUserDAO{

    List<User> allUsers = new ArrayList<User>();


    @Override
    public User save(User user) throws Exception {
        allUsers.add(user);
        return user;
    }

    @Override
    public List<User> fetchAll() {
        return allUsers;
    }
}

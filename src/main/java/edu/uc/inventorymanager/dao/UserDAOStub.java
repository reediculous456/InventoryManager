package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOStub implements IUserDAO {
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

    @Override
    public User fetchById(int id) {
        return allUsers.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        User user = this.fetchById(id);
        allUsers.remove(user);
    }
}

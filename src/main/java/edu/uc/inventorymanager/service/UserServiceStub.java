package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dao.IUserDAO;
import edu.uc.inventorymanager.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class UserServiceStub implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> fetchALl() {
        return null;
    }

    @Override
    public User fetchUserById(int id) {
        User user = new User();
        user.setName("Test Name");
        user.setId(id);
        return user;
    }

    @Override
    public List<User> fetchUsers(String id) throws IOException {
        return userDAO.fetchUsers(id);
    }
}

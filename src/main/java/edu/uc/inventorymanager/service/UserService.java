package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dao.IUserDAO;
import edu.uc.inventorymanager.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User save(User user) throws Exception {
        return userDAO.save(user);
    }

    @Override
    public List<User> fetchALl() {
        return userDAO.fetchAll();
    }

    @Override
    public User fetchUserById(int id) {
        return userDAO.fetchById(id);
    }
}

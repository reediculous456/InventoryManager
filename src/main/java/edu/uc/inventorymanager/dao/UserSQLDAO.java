package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDAO")
public class UserSQLDAO implements IUserDAO {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAll() {
        List<User> allUsers = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public User fetchById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}

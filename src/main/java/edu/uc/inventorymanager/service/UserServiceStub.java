package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceStub implements IUserService {
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
        user.setUserName("Test Name");
        user.setUserId(id);
        return user;
    }
}

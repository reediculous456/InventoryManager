package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceStub implements IUserService{
    @Override
    public void save(User user) {

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
}

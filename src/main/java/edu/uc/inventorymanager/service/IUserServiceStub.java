package edu.uc.inventorymanager.service;

import edu.uc.inventorymanager.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceStub implements IUserService{

    @Override
    public void save(User user) {

    }

    @Override
    public List<User> fetchALl() {
        return null;
    }

    @Override
    public User fetch(int id) {
        return null;
    }
}

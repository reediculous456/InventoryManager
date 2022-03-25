package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
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
    public List<User> fetchUsers(String category) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IUserRetrofitDAO userRetrofitDAO = retrofitInstance.create(IUserRetrofitDAO.class);
        Call<List<User>> allUsers = userRetrofitDAO.getUsers(category);
        Response<List<User>> execute = allUsers.execute();
        List<User> users = execute.body();
        return users;
    }

    public User fetchById(int id) {
        return allUsers.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void deleteById(int id) {
        User user = this.fetchById(id);
        allUsers.remove(user);
    }
}

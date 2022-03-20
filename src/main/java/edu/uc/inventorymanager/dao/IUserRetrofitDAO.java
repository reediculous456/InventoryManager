package edu.uc.inventorymanager.dao;

import edu.uc.inventorymanager.dto.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IUserRetrofitDAO {

    @GET("/v1/laureate.json")
    Call<List<User>> getUsers(@Query("id") String id);
}

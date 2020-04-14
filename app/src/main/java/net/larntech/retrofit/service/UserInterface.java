package net.larntech.retrofit.service;

import net.larntech.retrofit.model.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {


    @GET("users/")
    Call<List<UserResponse>> getAllUsers();

}

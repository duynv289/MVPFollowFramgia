package com.example.liz.mvpdemo.data.source;

import com.example.liz.mvpdemo.data.model.User;

import java.util.List;

public interface UserDataSource {
    interface LocalDataSource{
        void addUser(User user);

        List<User> getAllUser();
        boolean checkUserPassword(String username, String password);
        boolean checkUserExists(String username);
    }
    interface RemoteDataSource{

    }
}

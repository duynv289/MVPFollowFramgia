package com.example.liz.mvpdemo.data.reponsitory;

import com.example.liz.mvpdemo.data.model.User;
import com.example.liz.mvpdemo.data.source.UserDataSource;
import com.example.liz.mvpdemo.data.source.local.UserLocalDataSource;

import java.util.List;

public class UserRepository implements UserDataSource.LocalDataSource,UserDataSource.RemoteDataSource {

    private UserLocalDataSource mUserLocalDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource) {
        mUserLocalDataSource = userLocalDataSource;
    }

    @Override
    public void addUser(User user) {
        mUserLocalDataSource.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return mUserLocalDataSource.getAllUser();
    }

    @Override
    public boolean checkUserPassword(String username, String password) {
        return mUserLocalDataSource.checkUserPassword(username,password);
    }

    @Override
    public boolean checkUserExists(String username) {
        return mUserLocalDataSource.checkUserExists(username);
    }
}

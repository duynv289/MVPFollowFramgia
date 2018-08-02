package com.example.liz.mvpdemo.screen.signin;

import com.example.liz.mvpdemo.data.model.User;

import java.util.List;

public interface SignInContract {
    interface View{
        void showErrorWhenNotEntry();
        void showErrorWhenReentryPasswordWrong();
        void showSignInSuccessful();
        void showWhenUsernameExists();
        void clearText();
    }
    interface Presenter{
        void checkUser(String username,String password, String reEntryPassword,String email);
        void addUser(User user);
    }

}

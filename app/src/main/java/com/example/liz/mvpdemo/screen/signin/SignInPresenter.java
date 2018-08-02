package com.example.liz.mvpdemo.screen.signin;

import com.example.liz.mvpdemo.data.model.User;
import com.example.liz.mvpdemo.data.reponsitory.UserRepository;


public class SignInPresenter implements SignInContract.Presenter {
    private UserRepository mUserRepository;
    private SignInContract.View mView;

    public SignInPresenter(UserRepository userRepository, SignInContract.View view) {
        mUserRepository = userRepository;
        mView = view;
    }
    @Override
    public void addUser(User user){
        mUserRepository.addUser(user);
    }

    @Override
    public void checkUser(String username, String password, String reEntryPassword, String email) {
        boolean check = mUserRepository.checkUserExists(username);
        if(check){
            mView.showWhenUsernameExists();
        }
        else if(username.equals("") || password.equals("") || reEntryPassword.equals("") || email.equals("")) {
            mView.showErrorWhenNotEntry();
        }else if(!password.equals(reEntryPassword)){
            mView.showErrorWhenReentryPasswordWrong();
        }else{
            mView.showSignInSuccessful();
            mView.clearText();
        }
    }
}

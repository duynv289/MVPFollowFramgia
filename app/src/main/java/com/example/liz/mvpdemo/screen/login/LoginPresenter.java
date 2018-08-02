package com.example.liz.mvpdemo.screen.login;

import com.example.liz.mvpdemo.data.reponsitory.UserRepository;

public class LoginPresenter implements LoginContract.Presenter {

    private UserRepository mUserRepository;
    private LoginContract.View mView;

    public LoginPresenter(UserRepository userRepository, LoginContract.View view) {
        mUserRepository = userRepository;
        mView = view;
    }

    @Override
    public void checkCorrection(String username,String password) {
        if(mUserRepository.checkUserPassword(username,password)){
            mView.showDetail();
            mView.clearText();
        }else{
            mView.showError();
        }
    }
}

package com.example.liz.mvpdemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.liz.mvpdemo.screen.login.LoginFragment;
import com.example.liz.mvpdemo.screen.signin.SignInFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private static final int PAGER_NUMBER = 2;
    private static final String SIGN_IN = "Sign in";
    private static final String LOGIN = "Log in";
    private static final int SIGN_IN_POSITION = 0;
    private static final int LOGIN_POSITION = 1;


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case SIGN_IN_POSITION :
                fragment = SignInFragment.getNewInstance();
                break;
            case LOGIN_POSITION:
                fragment = LoginFragment.getNewInstance();
                break;
        }
        return fragment;
    }
    @Override
    public int getCount() {
        return PAGER_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String TITLE = "";
        switch (position){
            case SIGN_IN_POSITION:
                TITLE = SIGN_IN;
                break;
            case LOGIN_POSITION:
                TITLE = LOGIN;
                break;
        }
        return TITLE;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}

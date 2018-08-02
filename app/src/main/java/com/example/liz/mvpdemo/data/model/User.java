package com.example.liz.mvpdemo.data.model;

public class User {
    private int mId;
    private String mUsername;
    private String mPassword;
    private String mReentrypassword;
    private String mEmail;

    public User() {
    }

    public User(String username, String password, String reentrypassword, String email) {
        mUsername = username;
        mPassword = password;
        mReentrypassword = reentrypassword;
        mEmail = email;
    }

    public User(int id, String username, String password, String reentrypassword, String email) {
        mId = id;
        mUsername = username;
        mPassword = password;
        mReentrypassword = reentrypassword;
        mEmail = email;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getReentrypassword() {
        return mReentrypassword;
    }

    public void setReentrypassword(String reentrypassword) {
        mReentrypassword = reentrypassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mReentrypassword='" + mReentrypassword + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}

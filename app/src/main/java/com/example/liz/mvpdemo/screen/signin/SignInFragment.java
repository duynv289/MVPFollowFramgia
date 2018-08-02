package com.example.liz.mvpdemo.screen.signin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liz.mvpdemo.data.reponsitory.UserRepository;
import com.example.liz.mvpdemo.data.source.local.UserLocalDataSource;
import com.example.liz.mvpdemo.data.source.local.config.sqlite.DBUser;
import com.example.liz.mvpdemo.R;
import com.example.liz.mvpdemo.data.model.User;


public class SignInFragment extends Fragment implements View.OnClickListener, SignInContract.View{
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private EditText mEditTextReentryPassword;
    private EditText mEditTextEmail;
    private Button mButtonSigin;
    private DBUser mDBUser;
    private SignInContract.Presenter mPresenter;
    public static SignInFragment getNewInstance(){
        SignInFragment fragment = new SignInFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_signin,container,false);
        initView(view);
        mDBUser = new DBUser(getActivity());
        UserRepository userRepository = new UserRepository(new UserLocalDataSource(mDBUser));
        mPresenter = new SignInPresenter(userRepository,this);
        mButtonSigin.setOnClickListener(this);
        return view;

    }


    private void initView(View view) {
        mEditTextUsername = view.findViewById(R.id.edt_signin_username);
        mEditTextPassword = view.findViewById(R.id.edt_signin_password);
        mEditTextReentryPassword = view.findViewById(R.id.edt_reentry_password);
        mEditTextEmail = view.findViewById(R.id.edt_email);
        mButtonSigin = view.findViewById(R.id.button_signin);
    }


    @Override
    public void onClick(View view) {
        String username = mEditTextUsername.getText().toString();
        String password = mEditTextPassword.getText().toString();
        String reentrypassword = mEditTextReentryPassword.getText().toString();
        String email = mEditTextEmail.getText().toString();
        User user = new User(username,password,reentrypassword,email);
        mPresenter.checkUser(username,password,reentrypassword,email);
        mPresenter.addUser(user);
    }
    @Override
    public void clearText(){
        mEditTextUsername.setText("");
        mEditTextPassword.setText("");
        mEditTextReentryPassword.setText("");
        mEditTextEmail.setText("");
    }

    @Override
    public void showErrorWhenNotEntry() {
        Toast.makeText(getActivity(), getString(R.string.showErrorWhenNotEntry), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorWhenReentryPasswordWrong() {
        Toast.makeText(getActivity(), getString(R.string.showErrorWhenReentryPasswordWrong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSignInSuccessful() {
        Toast.makeText(getActivity(), getString(R.string.showSigninSuccesful), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showWhenUsernameExists() {
        Toast.makeText(getActivity(), getString(R.string.showWhenUsernameExists), Toast.LENGTH_SHORT).show();
    }
}

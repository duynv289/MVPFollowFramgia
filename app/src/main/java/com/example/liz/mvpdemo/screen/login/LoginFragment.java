package com.example.liz.mvpdemo.screen.login;

import android.content.Intent;
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
import com.example.liz.mvpdemo.screen.userdetail.DetailActivity;
import com.example.liz.mvpdemo.R;

public class LoginFragment extends Fragment implements View.OnClickListener,LoginContract.View{
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private LoginContract.Presenter mPresenter;
    private DBUser mDBUser;

    public static LoginFragment getNewInstance(){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_login,container,false);
        initView(view);
        mButtonLogin.setOnClickListener(this);
        mDBUser = new DBUser(getActivity());
        UserRepository mUserRepository = new UserRepository(new UserLocalDataSource(mDBUser));
        mPresenter = new LoginPresenter(mUserRepository,this);
        return view;
    }

    private void initView(View view) {
        mEditTextUsername = view.findViewById(R.id.edt_login_username);
        mEditTextPassword = view.findViewById(R.id.edt_login_password);
        mButtonLogin = view.findViewById(R.id.button_login);
    }
    @Override
    public void clearText(){
        mEditTextUsername.setText("");
        mEditTextPassword.setText("");
    }

    @Override
    public void onClick(View view) {
        String username = mEditTextUsername.getText().toString();
        String password = mEditTextPassword.getText().toString();
        mPresenter.checkCorrection(username,password);
        clearText();
    }

    @Override
    public void showDetail() {
        Intent intent = new Intent(getActivity(),DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), getString(R.string.showError), Toast.LENGTH_SHORT).show();
    }
}

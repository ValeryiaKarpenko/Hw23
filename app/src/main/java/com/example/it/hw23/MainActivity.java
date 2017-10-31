package com.example.it.hw23;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.it.hw23.fragments.LoginFragment;
import com.example.it.hw23.fragments.SuccessFragment;

public class MainActivity extends AppCompatActivity {

    private View loginButton;
    private Fragment mFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView() {
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showFragment(new LoginFragment());
        }
    });
    }

    private void showFragment(Fragment fragment) {
        mFrag = fragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    public void setLoginData() {
        showFragment(new SuccessFragment());
    }

    public void hideFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(mFrag);
        transaction.commit();
    }


}

package com.example.it.hw23;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.it.hw23.fragments.LoginFragment;
import com.example.it.hw23.fragments.SuccessFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment mFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        View loginButton = findViewById(R.id.login_button);
    }



    private void initView() {
        View loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showFragment(new LoginFragment());
        }
    });
        View signupButton = findViewById(R.id.button_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                          /* intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                           startActivity(intent);*/
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getFragmentManager().putFragment(outState,"myfragment",mFrag);
        super.onSaveInstanceState(outState);
    }
/*
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mFrag = getFragmentManager().getFragment(savedInstanceState,"myfragment");
        super.onRestoreInstanceState(savedInstanceState);
    }*/
}

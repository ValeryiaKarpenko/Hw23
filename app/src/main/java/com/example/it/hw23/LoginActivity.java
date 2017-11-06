package com.example.it.hw23;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String SAVED_DATA = "saved_data";
    public static String savedString = "";
    private View emailTextView;
    private View nameTextView;
    private View passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        emailTextView = findViewById(R.id.email_edit_text);
        nameTextView = findViewById(R.id.name_edit_text);
        passwordTextView = findViewById(R.id.password_edit_text);
    }

    private void initView() {
        View signupButton = findViewById(R.id.sign_up_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_DATA, savedString);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        savedString = savedInstanceState.getString(SAVED_DATA);
        super.onRestoreInstanceState(savedInstanceState);

    }
}
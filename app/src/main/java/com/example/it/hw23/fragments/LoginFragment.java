package com.example.it.hw23.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.it.hw23.MainActivity;
import com.example.it.hw23.R;

/**
 * Created by IT on 28.10.2017.
 */

public class LoginFragment extends Fragment {

    private View emailFrTextView;
    private View passwFrTextView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, null);
        view.findViewById(R.id.button_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setLoginData();
            }
        });
        view.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).hideFragment();
            }
        });
        return view;
    }



    private void initView(){
        emailFrTextView = view.findViewById(R.id.email_fr_edit_text);
        passwFrTextView = view.findViewById(R.id.password_fr_edit_text);
    }


}

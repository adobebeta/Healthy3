package com.example.adobebeta.healthy3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by adobebeta on 30/10/2018 AD.
 */

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container,false); //เชื่อมกับหน้า xml
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState); //ตั้งค่าevent ต่างๆ

        loginBtnPressed();
        registerBtnPressed();

    }

    void loginBtnPressed(){

        Button loginBtn = (Button) getView().findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _username = (EditText) getView().findViewById(R.id.username);
                EditText _password = (EditText) getView().findViewById(R.id.password);
                String username = (String) _username.getText().toString();
                String password = (String) _password.getText().toString();

                if (username.equals("1") && password.equals("1")){
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new BmiFragment())
                            .addToBackStack(null)
                            .commit();
                    Log.d("Login","GO TO BMI");
                }
                else{
                    Toast.makeText(getActivity(),"Please try again",Toast.LENGTH_SHORT).show();
                    Log.d("Login","incorrect username or password");
                }

            }


        });
    }

    void registerBtnPressed(){
        Button registerBtn = (Button) getView().findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
                Log.d("Login","GO TO REGISTER");
            }
        });
    }
}

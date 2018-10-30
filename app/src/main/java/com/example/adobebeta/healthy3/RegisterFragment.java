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

public class RegisterFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        Button registerBtn = (Button) getView().findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText username = (EditText) getView().findViewById(R.id.username);
                EditText name = (EditText) getView().findViewById(R.id.name);
                EditText age = (EditText) getView().findViewById(R.id.age);
                EditText password = (EditText) getView().findViewById(R.id.password);

                String _username = (String)username.getText().toString();
                String _name = (String) name.getText().toString();
                String _age = (String) age.getText().toString();
                String _password = (String) password.getText().toString();

                if (_username.isEmpty() || _name.isEmpty() || _age.isEmpty() || _password.isEmpty()){
                    Toast.makeText(getActivity(),"กรุณาระบุข้อมูลให้ครบถ้วน",Toast.LENGTH_SHORT).show();
                    Log.d("Register","SOME FIELD IS EMPTY");
                }
                else if (_username.equals("admin")){
                    Toast.makeText(getActivity(), "user นี้มีในระบบแล้ว", Toast.LENGTH_SHORT).show();
                    Log.d("Register","USER ALREADY EXIST");
                }
                else{
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new BmiFragment())
                            .addToBackStack(null)
                            .commit();
                    Log.d("Register","GOTO BMI");
                }
            }
        });




    }
}

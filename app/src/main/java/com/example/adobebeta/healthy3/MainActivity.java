package com.example.adobebeta.healthy3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.fragment_login);

//        ตั้งเพื่อเลือกว่าเอาหน้าไหนเป็นหน้าแรก
//        if (savedInstanceState == null){
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.main_view, new LoginFragment())
//                    .addToBackStack(null)
//                    .commit();
//        }

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new LoginFragment()).commit();
        }
    }
}

package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.navigationdrawer.home.HomeFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpNavigationDrawer();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,new HomeFragment()).commit();



    }
}

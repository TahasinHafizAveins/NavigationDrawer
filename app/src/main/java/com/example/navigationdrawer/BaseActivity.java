package com.example.navigationdrawer;

import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.navigationdrawer.nav.NavFragment;

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private FragmentManager manager;
    private NavFragment navFragment;

    public void setupToolbar() {
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

    }

    public void setUpNavigationDrawer(){
        setupToolbar();
        manager = getSupportFragmentManager();
        mDrawerLayout =  findViewById(R.id.drawer_layout);
        navFragment =
                (NavFragment) manager.findFragmentById(R.id.fragment_navigation_drawer);
        navFragment.setUp(mDrawerLayout, toolbar);
        //getSupportActionBar().setTitle(Constant.HOME);
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }
}

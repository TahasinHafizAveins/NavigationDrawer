package com.example.navigationdrawer.nav;


import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.about.AboutFragment;
import com.example.navigationdrawer.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavFragment extends Fragment implements View.OnClickListener {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;


    private TextView tvHome,tvAbout;


    public NavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tvHome = view.findViewById(R.id.home);
        tvAbout = view.findViewById(R.id.about);

        tvHome.setOnClickListener(this);
        tvAbout.setOnClickListener(this);
    }


    public void setUp( DrawerLayout layout, final Toolbar toolbar) {

        mDrawerLayout = layout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //if user gonna not seen the drawer before thats mean the drawer is open for the first tim
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home:
                getFragmentManager().beginTransaction().replace(R.id.main_container,new HomeFragment()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;

            case R.id.about:
                getFragmentManager().beginTransaction().replace(R.id.main_container,new AboutFragment()).commit();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
        }
    }
}

package com.example.amxyfa.tokojna;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private com.example.amxyfa.tokojna.HomeFragment homeFragment;
    private com.example.amxyfa.tokojna.TampilFragment tampilFragment;
    private com.example.amxyfa.tokojna.HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new com.example.amxyfa.tokojna.HomeFragment();
        tampilFragment = new com.example.amxyfa.tokojna.TampilFragment();
        historyFragment = new com.example.amxyfa.tokojna.HistoryFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.nav_home:

                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_tampil:

                        setFragment(tampilFragment);
                        return true;

                    case R.id.nav_history:

                        setFragment(historyFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment (Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}

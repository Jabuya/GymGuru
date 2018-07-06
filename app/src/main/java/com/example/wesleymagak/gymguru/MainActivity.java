package com.example.wesleymagak.gymguru;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager loginFragmentManager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_login:
                    loginFragmentManager.beginTransaction().replace(R.id.login_content, new LoginFragment()).commit();
                    return true;
                case R.id.navigation_register:
                    loginFragmentManager.beginTransaction().replace(R.id.login_content, new RegisterFragment()).commit();
                    return true;
                case R.id.navigation_settings:
                    loginFragmentManager.beginTransaction().replace(R.id.login_content, new SettingsFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragmentManager.beginTransaction().replace(R.id.login_content, new LoginFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.login_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}

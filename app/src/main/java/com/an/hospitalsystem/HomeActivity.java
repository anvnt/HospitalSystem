package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.MenuItem;

import com.an.hospitalsystem.NewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        final AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_news, R.id.navigation_consultant, R.id.navigation_booking,R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_news:
                        NewsFragment newsFragment=new NewsFragment();
                        FragmentManager newsmanager = getSupportFragmentManager();
                        newsmanager.beginTransaction().replace(R.id.nav_host_fragment,newsFragment,newsFragment.getTag()).commit();
                        return true;
                    case R.id.navigation_consultant:
                        ConsultantFragment consultantFragment =new ConsultantFragment();
                        FragmentManager conManager = getSupportFragmentManager();
                        conManager.beginTransaction().replace(R.id.nav_host_fragment,consultantFragment,consultantFragment.getTag()).commit();
                        return true;
                    case R.id.navigation_booking:
                        BookingFragment bookingFragment=new BookingFragment();
                        FragmentManager booManager = getSupportFragmentManager();
                        booManager.beginTransaction().replace(R.id.nav_host_fragment,bookingFragment,bookingFragment.getTag()).commit();
                        return true;
                    case R.id.navigation_profile:
                        ProfileFragment profileFragment=new ProfileFragment();
                        FragmentManager promanager = getSupportFragmentManager();
                        promanager.beginTransaction().replace(R.id.nav_host_fragment,profileFragment,profileFragment.getTag()).commit();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                }
            }
        });
    }

}

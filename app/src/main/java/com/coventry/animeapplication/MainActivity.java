package com.coventry.animeapplication;

import android.os.Bundle;

import com.coventry.animeapplication.ui.dashboard.DashboardFragment;
import com.coventry.animeapplication.ui.model.AnimeCharacters;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle btnSavedInstanceState) {
        super.onCreate(btnSavedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
        DashboardFragment.characters.add(new AnimeCharacters("20","Naruto Uzumaki","Tokyo","Male"));
        DashboardFragment.characters.add(new AnimeCharacters("21","Sakura Chan","Kyoto","Female"));
        DashboardFragment.characters.add(new AnimeCharacters("22","Kakasi Sensei","Osaka","Male"));
    }

}

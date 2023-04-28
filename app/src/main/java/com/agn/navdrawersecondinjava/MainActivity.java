package com.agn.navdrawersecondinjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.agn.navdrawersecondinjava.ui.Calls.CallsFragment;
import com.agn.navdrawersecondinjava.ui.CreateGroup.CreateGroupFragment;
import com.agn.navdrawersecondinjava.ui.HomeFragment;
import com.agn.navdrawersecondinjava.ui.massage.MassageFragment;
import com.agn.navdrawersecondinjava.ui.Settings.SettingsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this
                , drawerLayout
                , toolbar
                , R.string.open_naw, R.string.close_naw);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conteiner, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_conteiner, new HomeFragment())
                        .commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_conteiner, new SettingsFragment())
                        .commit();
                break;

            case R.id.nav_calls:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_conteiner, new CallsFragment())
                        .commit();
                break;

            case R.id.nav_crateGroups:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_conteiner, new CreateGroupFragment())
                        .commit();
                break;

            case R.id.nav_massages:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_conteiner, new MassageFragment())
                        .commit();
                break;

            case R.id.nav_telegram:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
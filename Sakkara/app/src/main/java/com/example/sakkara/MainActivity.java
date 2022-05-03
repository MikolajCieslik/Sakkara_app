package com.example.sakkara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mlayout = (DrawerLayout) findViewById(R.id.main_activity);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle mtoggle=new ActionBarDrawerToggle(this,mlayout,toolbar,R.string.open,R.string.close);
        mlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,
                    new glowna_fragment()).commit();
            navigationView.setCheckedItem(R.id.glowna);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.glowna:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new glowna_fragment()).commit();
                break;
            case R.id.menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new menu_fragment()).commit();
                break;
            case R.id.galeria:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new galeria_fragment()).commit();
                break;
            case R.id.kontakt:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new kontakt_fragment()).commit();
                break;
        }
        mlayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed(){
        if(mlayout.isDrawerOpen(GravityCompat.START)){
            mlayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}
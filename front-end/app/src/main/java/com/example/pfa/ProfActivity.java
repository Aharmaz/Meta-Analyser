package com.example.pfa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pfa.R;
import com.google.android.material.navigation.NavigationView;

public class ProfActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pour_prof);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new
                    EspaceProfFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_espace_prof);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_espace_prof:_:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EspaceProfFragment()).commit();
                break;
            case R.id.nav_liste_sujets_demandes_prof:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SujetsDemandesProfFragment()).commit();
                break;
            case R.id.nav_affectations_finales_prof:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AffectationsFinalesProfFragment()).commit();
                break;
            case R.id.nav_changer_mot_de_passe_prof:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChangerPasswdProfFragment()).commit();
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
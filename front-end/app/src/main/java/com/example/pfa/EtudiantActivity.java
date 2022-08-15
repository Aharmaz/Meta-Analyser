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

public class EtudiantActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pour_etudiant);

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
                    EspaceEtudiantFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_espace_etudiant);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_espace_etudiant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EspaceEtudiantFragment()).commit();
                break;
            case R.id.nav_sujets_props_etudiant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SujetsEtudiant()).commit();
                break;
            case R.id.nav_suivi_etudiant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SuiviSujetsEtudiantFragment()).commit();
                break;
            case R.id.nav_votre_grp_etudiant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AjouterGrpEtudiantFragment()).commit();
                break;
            case R.id.nav_changer_mot_de_passe_etudiant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChangerPasswdEtudiantFragment()).commit();
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
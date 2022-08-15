
package com.example.pfa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.View;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pfa.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ChefFiliereActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pour_chef_filiere);

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
                    EspaceChefFiliereFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_espace_chef_filiere);
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_espace_chef_filiere:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EspaceChefFiliereFragment()).commit();
                break;

            case R.id.nav_affectations_finales_chef_filiere:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AffectationsFinalesChefFiliereFragment()).commit();
                break;



            case R.id.nav_ajouter_sujet_chef_filiere:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AjouterSujetsChefFiliereFragment()).commit();
                break;
            case R.id.nav_sujets_prop_chef_filiere:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SujetsPropsChefFiliereFragment()).commit();
                break;
            case R.id.nav_changer_mot_de_passe_chef_filiere:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChangerPasswdChefFiliereFragment()).commit();
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



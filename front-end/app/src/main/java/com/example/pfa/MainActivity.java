package com.example.pfa;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import android.os.Bundle;

import com.example.pfa.R;

import ma.gi.pfa.RoleAdapter;
import ma.gi.pfa.RoleItem;

public class MainActivity extends AppCompatActivity {
    private ArrayList<RoleItem> mCountryList;
    private RoleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();



        };


    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new RoleItem("India", R.drawable.ic_ajouter_grp));
        mCountryList.add(new RoleItem("China", R.drawable.ic_ajouter_grp));
        mCountryList.add(new RoleItem("USA", R.drawable.ic_ajouter_grp));
        mCountryList.add(new RoleItem("Germany", R.drawable.ic_ajouter_grp));
    }
}
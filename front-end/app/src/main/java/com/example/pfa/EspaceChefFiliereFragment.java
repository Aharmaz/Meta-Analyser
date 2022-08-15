package com.example.pfa;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pfa.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class EspaceChefFiliereFragment extends Fragment implements  View.OnClickListener {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_espace_chef_filiere, container, false);

        Button btn1 = (Button) rootView.findViewById(R.id.ajouter_sujets_chef_filiere_btn);
        Button btn2 = (Button) rootView.findViewById(R.id.sujets_prop_chef_filiere_btn);
        Button btn3 = (Button) rootView.findViewById(R.id.affectations_finales_chef_filiere_btn);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);




        return rootView;

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.ajouter_sujets_chef_filiere_btn:
                fragment = new AjouterSujetsChefFiliereFragment();
                replaceFragment(fragment);
                break;
            case R.id.sujets_prop_chef_filiere_btn:
                fragment = new SujetsPropsChefFiliereFragment();
                replaceFragment(fragment);
                break;
            case R.id.affectations_finales_chef_filiere_btn:
                fragment = new AffectationsFinalesChefFiliereFragment();
                replaceFragment(fragment);
                break;

        }

    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }







}
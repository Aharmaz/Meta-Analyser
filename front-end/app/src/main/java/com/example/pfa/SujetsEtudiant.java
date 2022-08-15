package com.example.pfa;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class SujetsEtudiant extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    RecyclerView recyclerView;

    ArrayList<Sujet> sujetArrayList;

    AdapterSujets myAdapter;

    FirebaseFirestore db;

    public SujetsEtudiant() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SujetsEtudiant newInstance(String param1, String param2, String param3) {
        SujetsEtudiant fragment = new SujetsEtudiant();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sujets_etudiant2, container, false);

        recyclerView = view.findViewById(R.id.recycler);

        db = FirebaseFirestore.getInstance();
        sujetArrayList = new ArrayList<Sujet>();
        myAdapter = new AdapterSujets(getContext(), sujetArrayList);
        recyclerView.setAdapter(myAdapter);
        EventChangeListener();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void EventChangeListener(){


        db.collection("ChefFiliere").document("chef1").collection("SujetsAjoutes").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {


                    Log.e("FireStore error", error.getMessage());
                    return ;

                }
                for (DocumentChange dc : value.getDocumentChanges()){

                    if (dc.getType() == DocumentChange.Type.ADDED){
                        sujetArrayList.add(dc.getDocument().toObject(Sujet.class));
                    }

                }
                myAdapter.notifyDataSetChanged();

            }
        });

    }

}
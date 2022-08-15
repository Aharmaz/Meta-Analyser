package com.example.pfa;



import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class AdapterSujets extends RecyclerView.Adapter<AdapterSujets.HolderSujet> {

    Context context;
    ArrayList<Sujet> sujetArrayList;

    public AdapterSujets(Context context, ArrayList<Sujet> sujetArrayList){

        this.context = context;
        this.sujetArrayList = sujetArrayList;
    }



    @NonNull
    @Override
    public HolderSujet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.sujet_item, parent, false);
        return new HolderSujet(v);
    }

    @Override
    public void onBindViewHolder(AdapterSujets.HolderSujet holder, int position){

        Sujet sujet = sujetArrayList.get(position);
        holder.titre.setText(sujet.getTitre());
        holder.encadrant.setText(sujet.getEncadrant());
        holder.nbMax.setText(sujet.getNbMax());
    }

    @Override
    public int getItemCount(){
        return sujetArrayList.size();
    }

    public  static class HolderSujet extends RecyclerView.ViewHolder {

        TextView titre, nbMax, encadrant;

        public HolderSujet (View itemView){
            super(itemView);

            titre = itemView.findViewById((R.id.titre_sujet_db));
            encadrant = itemView.findViewById((R.id.encadrant_sujet_db));
            nbMax = itemView.findViewById((R.id.nb_max_sujet_db));
        }

    }


}



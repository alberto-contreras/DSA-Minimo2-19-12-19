package com.example.minimo2dsa_19_12_2019;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.minimo2dsa_19_12_2019.models.Element;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderData> {

    public static final String EXTRA_TEXT = "com.example.minimo2dsa_19_12_2019.example.EXTRA_TEXT";
    //LIST OF ITEMS
    List<Element> listofdata;//List that we are going to receive
    int globalposition;
    public RecyclerViewAdapter(List<Element> listofdata)
    {
        this.listofdata = listofdata;

    }
    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item,null,false);

        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        //Assign the data to each component of the layout
        holder.tvMuseum.append(listofdata.get(position).getAdrecaNom());//Variables assigned in the  ViewHolderData
        Picasso.with(holder.imgMuseum.getContext()).load("" + listofdata.get(position).getImatge().get(0)).into(holder.imgMuseum);
        if (position == globalposition) {


        }
    }

    @Override
    public int getItemCount() { return listofdata.size(); }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        //We have to make reference to all the data of the layout list --> Image,TextView..
        public ImageView imgMuseum;
        public TextView tvMuseum;
        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            //Reference items of the layout that we create to print it for each item
            imgMuseum = itemView.findViewById(R.id.museumimage);
            tvMuseum = itemView.findViewById(R.id.tvmuseum);
            tvMuseum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    globalposition = getAdapterPosition();
                }
            });
        }

    }
}

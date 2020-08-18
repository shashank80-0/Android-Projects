package com.example.recyclerviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter <PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public PersonAdapter (Context context, ArrayList<Person> list){
        people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPref;
        TextView tvName;
        TextView tvSurname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            ivPref = itemView.findViewById(R.id.ivPref);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById((R.id.tvSurname));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(people.indexOf((Person)v.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(people.get(position));

        holder.tvName.setText(people.get(position).getName());
        holder.tvSurname.setText(people.get(position).getSurname());

        if(people.get(position).getPreference().equals("bus")){
            holder.ivPref.setImageResource(R.drawable.bus);
        }

        else if (people.get(position).getPreference().equals("flight")){
            holder.ivPref.setImageResource(R.drawable.flight);
        }

    }

    @Override
    public int getItemCount() {
        return people.size()    ;
    }
}

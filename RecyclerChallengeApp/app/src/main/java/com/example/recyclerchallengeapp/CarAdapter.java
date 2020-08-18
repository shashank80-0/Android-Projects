package com.example.recyclerchallengeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter <CarAdapter.ViewHolder> {

    private ArrayList<Car> vehicle;
    itemClicked activity;

    public interface itemClicked {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> list){

        vehicle = list;
        activity =(itemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvModel, tvName;
        ImageView ivMake;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvName = itemView.findViewById(R.id.tvName);
            ivMake = itemView.findViewById(R.id.ivMake);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(vehicle.indexOf((Car) v.getTag()));

                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {

    holder.itemView.setTag(vehicle.get(position));

    holder.tvName.setText(vehicle.get(position).getOwner());
    holder.tvModel.setText(vehicle.get(position).getModel());

        switch (vehicle.get(position).getMake()) {
            case "Volkswagen":
                holder.ivMake.setImageResource(R.drawable.volkswagen);
                break;
            case "Mercedes":
                holder.ivMake.setImageResource(R.drawable.mercedes);
                break;
            case "Nissan":
                holder.ivMake.setImageResource(R.drawable.nissan);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return vehicle.size();
    }
}

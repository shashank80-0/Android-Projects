package com.example.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final ArrayList<Product> values;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.row_layout, list);
        this.context = context;
        this.values = list;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowview = inflater.inflate(R.layout.row_layout, parent, false);

        TextView tvProduct = rowview.findViewById(R.id.tvProduct);
        TextView tvPrice = rowview.findViewById(R.id.tvPrice);
        TextView tvDescription = rowview.findViewById(R.id.tvDescription);
        ImageView ivProduct = rowview.findViewById(R.id.ivProduct);
        ImageView ivSale = rowview.findViewById(R.id.ivSale);

        tvProduct.setText(values.get(position).getTitle());
        tvPrice.setText("$ " + values.get(position).getPrice());
        tvDescription.setText(values.get(position).getDescription());

        if(values.get(position).getSale()){
            ivSale.setImageResource(R.mipmap.sale);
        }
        else{
            ivSale.setImageResource(R.mipmap.best_price);
        }

        switch (values.get(position).getType()) {
            case "Laptop":
                ivProduct.setImageResource(R.mipmap.laptop);
                break;
            case "Memory":
                ivProduct.setImageResource(R.mipmap.memory);
                break;
            case "Hdd":
                ivProduct.setImageResource(R.mipmap.hdd);
                break;
            case "Screen":
                ivProduct.setImageResource(R.mipmap.screen);
                break;
        }

        return rowview;
    }
}

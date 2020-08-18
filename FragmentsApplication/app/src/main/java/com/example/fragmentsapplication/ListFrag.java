package com.example.fragmentsapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFrag extends ListFragment {


    // TODO: Rename and change types and number of parameters
    public ListFrag() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data = new ArrayList<String>();
        data.add("Shashank");
        data.add("Shubham");
        data.add("Manish");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
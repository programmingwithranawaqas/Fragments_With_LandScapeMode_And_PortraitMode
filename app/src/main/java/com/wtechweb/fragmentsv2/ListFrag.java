package com.wtechweb.fragmentsv2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFrag extends ListFragment {

    ItemSelected parentActivity;

    public interface ItemSelected
    {
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parentActivity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // hard code data
        String[] items = getResources().getStringArray(R.array.pieces);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        parentActivity.onItemSelected(position);
    }
}

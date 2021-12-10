package ca.qc.johnabbott.finalproject.UI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.Model.MenuData;
import ca.qc.johnabbott.finalproject.R;

public class MenuItems extends Fragment {


    public MenuItems() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_item, container, false);

        TextView text = (TextView) view.findViewById(R.id.textItem);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snackBarText = " ";
            }
        });
        return view;
    }

    @Override
    public  void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);



    }
}
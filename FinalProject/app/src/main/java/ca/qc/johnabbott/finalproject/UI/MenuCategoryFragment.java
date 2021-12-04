package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.Model.MenuData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.qc.johnabbott.finalproject.R;


public class MenuCategoryFragment extends Fragment {

    List<String> listHeader;
    HashMap<String,List<MenuItem>> items;
    ExpandableListView expandableListView;

    public MenuCategoryFragment() {
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
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public  void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);

        expandableListView = view.findViewById(R.id.expandableListView);
        items = MenuData.getData();
        listHeader = new ArrayList<String>(items.keySet());
        expandableListView.setAdapter(new ExpandableListAdapter(listHeader, items, this));
        expandableListView.setGroupIndicator(null);


    }
}
package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.airbnb.lottie.L;

import ca.qc.johnabbott.finalproject.Model.DBHandler;
import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.Model.MenuData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;


public class MenuCategoryFragment extends Fragment {

    List<String> listHeader;
    HashMap<String,List<MenuItem>> items;
    ExpandableListView expandableListView;
    private DBHandler dbHandler;

    public MenuCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = ((MainActivity)getActivity()).getDBhandler();

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
        try {
            List<MenuItem> list = dbHandler.getMenuItemTable().readAll();
            items = groupByHashMap(list);
            //items = MenuData.getData();
            //listHeader = new ArrayList<>(items.keySet());
            listHeader = new ArrayList<>();

            for(Map.Entry<String,List<MenuItem>> entry : items.entrySet())
            {
                listHeader.add(entry.getKey());

            }

            expandableListView.setAdapter(new ExpandableListAdapter(listHeader, items, this));
            expandableListView.setGroupIndicator(null);


        } catch (DatabaseException e) {
            e.printStackTrace();
        }





    }
    private HashMap<String, List<MenuItem>> groupByHashMap(List<MenuItem> items)
    {
        HashMap<String, List<MenuItem>> hashMap = new HashMap<>();
        for(MenuItem menuItem: items){
            if(!hashMap.containsKey(menuItem.getCategory())){
                hashMap.put(menuItem.getCategory(), new ArrayList<MenuItem>());
            }
            hashMap.get(menuItem.getCategory()).add(menuItem);
        }

        return hashMap;
    }
}
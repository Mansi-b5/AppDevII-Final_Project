package ca.qc.johnabbott.finalproject.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private HashMap<String, List<MenuItem>> items;
    private List<String> listHeader;

    public ExpandableListAdapter(List<String> listHeader,HashMap<String,List<MenuItem>> items)
    {
        this.items = items;
        this.listHeader = listHeader;
    }

    @Override
    public int getGroupCount() {
        return this.listHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.items.get(this.listHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listHeader.get(i);
    }

    @Override
    public Object getChild(int groupPos, int itemPos) {
        return items.get(listHeader.get(groupPos)).get(itemPos);
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
    }

    @Override
    public long getChildId(int groupPos, int itemPos) {
        return itemPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean isExpanded, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_menu_group,viewGroup,false);
        }

        TextView textView = view.findViewById(R.id.expandedListGroup);
        LinearLayout linearLayout = view.findViewById(R.id.cardViewColor);
        ImageView imageView = view.findViewById(R.id.image);

        if(listHeader.get(groupPos) == "Pizza")
        {
            textView.setText(String.valueOf(getGroup(groupPos)));
            linearLayout.setBackgroundResource(R.drawable.gradient1);
            imageView.setBackgroundResource(R.drawable.ic_baseline_local_pizza_24);
        }
        else if(listHeader.get(groupPos) == "Sides")
        {
            textView.setText(String.valueOf(getGroup(groupPos)));
            linearLayout.setBackgroundResource(R.drawable.gradient2);
            imageView.setBackgroundResource(R.drawable.ic_baseline_fastfood_24);
        }
        else if(listHeader.get(groupPos) == "Drinks"){
            textView.setText(String.valueOf(getGroup(groupPos)));
            linearLayout.setBackgroundResource(R.drawable.gradient3);
            imageView.setBackgroundResource(R.drawable.ic_baseline_local_drink_24);
        }

        return view;
    }

    @Override
    public View getChildView(int groupPos, int itemPos, boolean isLast, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_menu_item,viewGroup,false);
        }


        Object item = items.get(listHeader.get(groupPos)).get(itemPos).getTitle();

        TextView textView = view.findViewById(R.id.textItem);
        textView.setText(String.valueOf(item));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

}

package ca.qc.johnabbott.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.johnabbott.finalproject.Model.Location;
import ca.qc.johnabbott.finalproject.databinding.ListItemLocationBinding;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {

    private final Context context;
    private List<Location> data;

    public LocationListAdapter(Context context, List<Location> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ListItemLocationBinding binding;
        private Location location;

        public ViewHolder(@NonNull ListItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Location location){
            this.location = location;

            binding.address.setText(location.getAddress());
            binding.hours.setText(location.getHours());
            binding.phone.setText(location.getPhoneNumber());
            binding.map.setText(location.getMap());
        }


    }
}

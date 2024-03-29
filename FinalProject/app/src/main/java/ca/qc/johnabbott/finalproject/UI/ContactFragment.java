package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;

import ca.qc.johnabbott.finalproject.LocationListAdapter;
import ca.qc.johnabbott.finalproject.Model.LocationD;
import ca.qc.johnabbott.finalproject.Model.LocationData;
import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentContactBinding;

public class ContactFragment extends Fragment implements OnMapReadyCallback {

    private FragmentContactBinding binding;
    private LocationListAdapter adapter;

    private MapView mapView;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentContactBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        mapView = (MapView) view.findViewById(R.id.mapView);

        initGoogleMap(savedInstanceState);

        //binding = FragmentContactBinding.inflate(inflater, container, false);
        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new LocationListAdapter(getContext(), LocationData.getData());
        binding.locationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.locationRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initGoogleMap(Bundle savedInstanceState) {
        Bundle mapViewBundle = null;
        if(savedInstanceState != null){
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if(mapViewBundle == null){
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }
        mapView.onSaveInstanceState(mapViewBundle);
    }
    @Override
    public void onResume(){
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onStart(){
        mapView.onStart();
        super.onStart();
    }

    @Override
    public void onStop(){
        mapView.onStop();
        super.onStop();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        //Hardcoded values to abbott because getting the location of the users actual current location was a little too complicated for me. -Bhavik
        //Zoom
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(45.40658109095025, -73.94171747323092), 10.0f));

        View view = binding.getRoot();
        //A marker is made for each location in the list
        for (LocationD locationl: LocationData.getData()) {
            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(@NonNull Marker marker) {
                    //Snackbar pops up, saying that a spot has been selected.
                    Snackbar snackbar = Snackbar.make(view, marker.getTitle()+" Selected", 1000);
                    snackbar.show();

                    MainActivity mainActivity = (MainActivity) getActivity();

                    for (LocationD location2: LocationData.getData()) {
                        if(marker.getTitle().equals(location2.getName()))
                        {
                            location2.setSelected(true);
                            //Sets a location in the cart page
                            mainActivity.getOrderViewModel().getOrder().setLocation(location2);
                        }
                        else{
                            location2.setSelected(false);
                        }
                    }

                    return false;
                }
            });
            //Could not figure out how to make the marker boxes bigger.
            googleMap.addMarker(new MarkerOptions().position(new LatLng(locationl.getLatitude(), locationl.getLongitude())).title(locationl.getName()).snippet(locationl.getAddress()));
        }

    }

    @Override
    public void onPause(){
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy(){
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory(){
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
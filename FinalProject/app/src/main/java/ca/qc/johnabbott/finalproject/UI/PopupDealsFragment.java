package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentHomeBinding;
import ca.qc.johnabbott.finalproject.databinding.FragmentPopupdealswindowBinding;

public class PopupDealsFragment extends Fragment {

    private String _combo;
    private String _price;
    private FragmentPopupdealswindowBinding binding;



    public String get_combo() {
        return _combo;
    }

    public void set_combo(String _combo) {
        this._combo = _combo;
    }

    public String get_price() {
        return _price;
    }

    public void set_price(String _price) {
        this._price = _price;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPopupdealswindowBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.comboNameTextview.setText(get_combo());
        binding.priceOfComboTextview.setText(get_price());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}

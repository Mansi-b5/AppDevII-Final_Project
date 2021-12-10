package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentPopupdealswindowBinding;

public class PopupDealsFragment extends DialogFragment {

    private String _combo;
    private String _price;
    private int _image;
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

    public void set_image (int _image)
    {
        this._image = _image;
    }
    public int get_image()
    {
        return this._image;
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
        binding.dealsImageView.setImageResource(get_image());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}

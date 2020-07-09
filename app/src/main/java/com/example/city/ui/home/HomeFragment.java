package com.example.city.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.city.CityAdapter;
import com.example.city.CityItem;
import com.example.city.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<CityItem> cityItems = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CityAdapter(cityItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        cityItems.add(new CityItem(R.drawable.kandy, "Kandy", "0", "0"));
        cityItems.add(new CityItem(R.drawable.colombo, "Colombo", "1", "0"));
        cityItems.add(new CityItem(R.drawable.galle, "Galle", "3", "0"));
        cityItems.add(new CityItem(R.drawable.anuradhapura_sri_lanka_featured_image, "Anuradhapura", "4", "0"));

        return root;
    }
}

package com.example.pokeapi;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemFragment extends Fragment {

    private Pokemon pokemon;
    private TextView textViewName;

    public ItemFragment(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_item, container, false);
        wireWidgets(rootView);
        setValues();
        return rootView;
    }

    private void setValues() {
        textViewName.setText(pokemon.getName());
    }

    private void wireWidgets(View rootView) {
        textViewName = rootView.findViewById(R.id.textView_item_name);
    }
}

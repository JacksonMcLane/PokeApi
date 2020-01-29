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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {

    private Pokemon pokemon;
    private TextView textViewName, textViewId, textViewHeight, textViewWeight, textViewAbilities;
    private TextView textViewMoves, textViewStats, textViewTypes;

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
        textViewId.setText(String.valueOf(pokemon.getId()));
        textViewHeight.setText(String.valueOf(pokemon.getHeight()));
        textViewWeight.setText(String.valueOf(pokemon.getWeight()));
        textViewAbilities.setText(getListAsString(pokemon.getAbilities()));
    }

    private CharSequence getListAsString(List<Ability> abilities) {
        StringBuilder sb = new StringBuilder();
        for (Ability ability : abilities)
        {
            String s = ability.getName();
            sb.append(s);
            sb.append("\t");
        }

        return sb.toString();
    }

    private void wireWidgets(View rootView) {
        textViewName = rootView.findViewById(R.id.textView_item_name);
        textViewId = rootView.findViewById(R.id.textView_item_id);
        textViewHeight = rootView.findViewById(R.id.textView_item_height);
        textViewWeight = rootView.findViewById(R.id.textView_item_weight);
        textViewAbilities = rootView.findViewById(R.id.textView_item_abilities);
        textViewMoves = rootView.findViewById(R.id.textView_item_moves);
        textViewStats = rootView.findViewById(R.id.textView_item_stats);
        textViewTypes = rootView.findViewById(R.id.textView_item_types);

    }
}

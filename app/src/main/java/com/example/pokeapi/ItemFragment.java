package com.example.pokeapi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
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
        textViewAbilities.setText(getAbilitiesAsString(pokemon.getAbilities()));
        textViewMoves.setText(getMovesAsString(pokemon.getMoves()));
        textViewStats.setText(getStatsAsString(pokemon.getStats()));
        textViewTypes.setText(getTypesAsString(pokemon.getTypes()));
    }

    private CharSequence getAbilitiesAsString(List<PokemonAbility> abilities) {
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (PokemonAbility ability : abilities)
        {

            String s = ability.getAbility().getName();
            sb.append(s);
            sb.append("\t");
            if(count%3 == 0){
                sb.append("\n");
            }
            count++;
        }

        return sb.toString();
    }

    private CharSequence getMovesAsString(List<PokemonMove> moves) {
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (PokemonMove move : moves)
        {
            String s = move.getMove().getName();
            sb.append(s);
            sb.append("\t");
            if(count % 3 == 0){
                sb.append("\n");
            }
            count++;
        }

        return sb.toString();
    }

    private CharSequence getStatsAsString(List<PokemonStat> stats) {
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (PokemonStat stat : stats)
        {
            String s = stat.getStat().getName();
            sb.append(s);
            sb.append("\t");
            if(count % 3 == 0){
                sb.append("\n");
            }
            count++;
        }

        return sb.toString();
    }

    private CharSequence getTypesAsString(List<PokemonType> types) {
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (PokemonType type : types)
        {
            String s = type.getType().getName();
            sb.append(s);
            sb.append("\t");
            if(count % 3  == 0){
                sb.append("\n");
            }
            count++;

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

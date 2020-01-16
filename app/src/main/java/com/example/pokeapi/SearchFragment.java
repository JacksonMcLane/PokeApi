package com.example.pokeapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {

    private PokemonService pokemonService;
    private Retrofit retrofit;
    private Button buttonSearch;
    private EditText editTextPokeNum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_search, container, false);
        wireWidgets(rootView);
        setListeners();
        retrofit = new Retrofit.Builder()
                .baseUrl(PokemonService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokemonService = retrofit.create(PokemonService.class);
        return rootView;
    }

    private void setListeners() {
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPokemonByDexNumOrName(pokemonService, String.valueOf(editTextPokeNum.getText()));
            }
        });
    }

    private void wireWidgets(View rootView) {
        editTextPokeNum = rootView.findViewById(R.id.editText_pokeNum);
        buttonSearch = rootView.findViewById(R.id.button_search);
    }

    private void getPokemonByDexNumOrName(PokemonService pokemonService, String dexNum) {
        Call<Pokemon> pokemonCall = pokemonService.getPokemonByDexNum(dexNum);
        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon foundPokemon = response.body();
                if(foundPokemon != null) {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    Fragment fragment = new ItemFragment(foundPokemon);
                    if (fragment != null) {
                        fm.beginTransaction()
                                .replace(R.id.contraintLayout_item_container, fragment)
                                .commit();
                    }
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

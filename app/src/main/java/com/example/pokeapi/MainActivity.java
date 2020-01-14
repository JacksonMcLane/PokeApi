package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private PokemonService pokemonService;
    private Retrofit retrofit;
    private Button buttonSearch;
    private EditText editTextPokeNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        retrofit = new Retrofit.Builder()
                .baseUrl(PokemonService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokemonService = retrofit.create(PokemonService.class);

    }

    private void setListeners() {
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPokemonByDexNum(pokemonService, String.valueOf(editTextPokeNum.getText()));
            }
        });
    }

    private void wireWidgets() {
        editTextPokeNum = findViewById(R.id.editText_main_pokeNum);
        buttonSearch = findViewById(R.id.button_main_search);
    }

    private void getPokemonByDexNum(PokemonService pokemonService, String dexNum) {
        Call<Pokemon> pokemonCall = pokemonService.getPokemonByDexNum(dexNum);
        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon foundPokemon = response.body();
                if(foundPokemon != null) {
                    Toast.makeText(MainActivity.this, foundPokemon.getName(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

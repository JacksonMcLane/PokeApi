package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private PokemonService pokemonService;
    private Retrofit retrofit;

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
        randomPokemon(pokemonService);
    }

    private void setListeners() {
    }

    private void wireWidgets() {
    }

    private void randomPokemon(PokemonService pokemonService) {
        Call<Pokemon> pokemonCall = pokemonService.getPokemonByDexNum("1");
        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon foundPokemon = response.body();
                Toast.makeText(MainActivity.this, foundPokemon.getName(), Toast.LENGTH_LONG).show();
                //Picasso.get().load(foundPokemon.getId()).into(imageViewDogPhoto);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

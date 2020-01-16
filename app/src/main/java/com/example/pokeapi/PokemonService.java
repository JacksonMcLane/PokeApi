package com.example.pokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";
    @GET("{dexNumOrName}/")
    Call<Pokemon> getPokemonByDexNum(@Path("dexNumOrName") String dexNumOrName);
}

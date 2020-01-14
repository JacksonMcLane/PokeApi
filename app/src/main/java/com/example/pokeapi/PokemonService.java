package com.example.pokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("breed/{breed}/images/random")
    Call<Pokemon> getPokemonByDexNum(@Path("dexNum") String dexDum);
}

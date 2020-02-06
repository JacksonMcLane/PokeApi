package com.example.pokeapi;

public class PokemonAbility {

    private String name;
    private NamedAPIResource ability;

    public PokemonAbility(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedAPIResource getAbility() {
        return ability;
    }

    public void setAbility(NamedAPIResource ability) {
        this.ability = ability;
    }
}

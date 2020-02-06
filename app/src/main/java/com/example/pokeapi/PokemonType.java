package com.example.pokeapi;

public class PokemonType {
    private String name;
    private NamedAPIResource type;

    public PokemonType(){

    }

    public NamedAPIResource getType() {
        return type;
    }

    public void setType(NamedAPIResource type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

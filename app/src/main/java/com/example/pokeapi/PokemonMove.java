package com.example.pokeapi;

public class PokemonMove {
    private String name;
    private NamedAPIResource move;

    public PokemonMove(){

    }

    public NamedAPIResource getMove() {
        return move;
    }

    public void setMove(NamedAPIResource move) {
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

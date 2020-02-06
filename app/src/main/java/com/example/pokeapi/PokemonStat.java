package com.example.pokeapi;

public class PokemonStat {
    private String name;
    private NamedAPIResource stat;
    private int base_stat;

    public PokemonStat(){

    }

    public NamedAPIResource getStat() {
        return stat;
    }

    public void setStat(NamedAPIResource stat) {
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

}

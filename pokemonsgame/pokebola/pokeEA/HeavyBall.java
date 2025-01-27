package pokemonsgame.pokebola.pokeEA;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class HeavyBall extends Pokebola {

    public HeavyBall(){
        super("HeavyBall", 1.0f);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon){
        if (pokemon.getPeso() < 100){
            pokemon.setTaxaDeCaptura(-20);
        } else if (pokemon.getPeso() < 200){
            pokemon.setTaxaDeCaptura(0);
        } else if (pokemon.getPeso() < 300){
            pokemon.setTaxaDeCaptura(20);
        } else if (pokemon.getPeso() >= 300){
            pokemon.setTaxaDeCaptura(30);
        }
    }
}

package pokemonsgame.pokebola.pokeEA;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class HeavyBall extends Pokebola {

    public HeavyBall(){
        super("HeavyBall", 1.0f);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon){

        double base = pokemon.getTaxaDeCaptura();
        double modificador = 0;
        
        if (pokemon.getPeso() < 100){
            modificador = -20;
        } else if (pokemon.getPeso() >= 300){
            modificador = 30;
        } else if (pokemon.getPeso() >= 200){
            modificador = 20;
        }

        if (base + modificador <= 0){
            this.bonusBall = 0.1f;
        } else {
            this.bonusBall = (float)((base + modificador) / base);
        }
    }
}

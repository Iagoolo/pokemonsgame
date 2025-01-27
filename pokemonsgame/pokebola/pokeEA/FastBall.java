package pokemonsgame.pokebola.pokeEA;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class FastBall extends Pokebola{
    
    public FastBall(){
        super ("FastBall", 1.0f);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon){
        if (pokemon.getVelocidade() >= 100){
            bonusBall *= 4.0f;
        }
    }
}

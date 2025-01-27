package pokemonsgame.pokebola.pokeTC;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class MasterBall extends Pokebola{
    
    public MasterBall(){
        super ("MasterBall", 1.0f);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon){
        System.out.println("Efeito de captura certa ativada");
    }

    @Override
    public boolean capturar(Pokemon pokemon){
        aplicarEfeito(pokemon);
        return true;
    }
}

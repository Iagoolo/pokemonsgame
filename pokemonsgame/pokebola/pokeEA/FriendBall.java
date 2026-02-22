package pokemonsgame.pokebola.pokeEA;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class FriendBall extends Pokebola {

    public FriendBall(){
        super("FriendBall", 1.0f);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon){}

    @Override
    public void aplicarEfeitoPosCaptura(Pokemon pokemon){
        pokemon.setAmizade(200);
        System.out.println("Pontos de amizade com o Pokemon alterados para +200!!");
    }
}   

package pokemonsgame.pokebola.pokeEA;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class HealBall extends Pokebola{
    
    public HealBall(){
        super("HealBall", 1.0f);
    }

    @Override
    public void aplicarEfeito(Pokemon pokemon){
        System.out.println("Restaurado o HP, o PP e qualquer condição de status do pokemon capturado");
        int cura = pokemon.getHpMax() - pokemon.getHpAtual();
        pokemon.curar(cura);
    }
}

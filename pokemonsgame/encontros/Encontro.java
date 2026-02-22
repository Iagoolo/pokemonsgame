package pokemonsgame.encontros;

import java.util.concurrent.ThreadLocalRandom;

import pokemonsgame.apppokemons.Pokemon;

// Classe reponsável por selecionar o pokemon e o seu nível
public class Encontro {

  public static Pokemon getRandomPokemon() {
    int sorteado = ThreadLocalRandom.current().nextInt(EspeciePokemon.values().length);
    EspeciePokemon base  = EspeciePokemon.values()[(sorteado)];

    int nivelSorteado = ThreadLocalRandom.current().nextInt(1, 6);
    
    return new Pokemon(base, nivelSorteado);
  }
}
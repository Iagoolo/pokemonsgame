package pokemonsgame.encontros;

import java.util.Random;
import pokemonsgame.apppokemons.Pokemon;

public class Encontro {

  public static Pokemon getRandomPokemon() {
    Random random = new Random();
    int sorteado = random.nextInt(EspeciePokemon.values().length);
    EspeciePokemon base  = EspeciePokemon.values()[(sorteado)];
    return new Pokemon(sorteado + 1, base.getNome(), base.getHpBase(), base.getAtaqueBase(), base.getDefesaBase(), base.getVelocidadeBase(), base.getAmizadeBase(), base.getPeso(), base.getTaxaDeCaptura());
  }
}
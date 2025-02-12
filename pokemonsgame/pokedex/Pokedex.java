package pokemonsgame.pokedex;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.encontros.EspeciePokemon;
import pokemonsgame.batalha.Registravel;

import java.util.*;

public class Pokedex implements Registravel {
  private List<Pokemon> capturados;
  private int[] ocorrencias = new int[151];

  public Pokedex() {
    capturados = new ArrayList<>();
  }

  @Override
  public void registrarEncontro(Pokemon pokemon) {
    int posicaoPokemon = pokemon.getEspecie() - 1;
    ocorrencias[posicaoPokemon]++;
  }

  @Override
  public void registrarCaptura(Pokemon pokemon) {
    capturados.add(pokemon);
  }

  public List<EspeciePokemon> listarVistos() {
    List<EspeciePokemon> pokemons = new ArrayList<>();
    for( int i = 0; i < ocorrencias.length; i++ ) {
      if(ocorrencias[i] > 0) {
        pokemons.add(EspeciePokemon.values()[i]);
      }
    }
    return pokemons;
  }

  public List<Pokemon> listarCapturados() {
    capturados.sort((o1, o2) -> o1.getEspecie() - o2.getEspecie());
    return capturados;
  }

  public long contarCapturasPorEspecie(EspeciePokemon pokemon) {
    return capturados.stream().filter(p -> p.getNome().equals(pokemon.getNome())).count();
  }

  public long contarVisualizacoes(EspeciePokemon pokemon) {
    return ocorrencias[pokemon.ordinal()];
  }

  public double taxaDeSucess(EspeciePokemon pokemon) {
    long capturados =  contarCapturasPorEspecie(pokemon);
    return (capturados/ocorrencias[pokemon.ordinal()])*100;
  }
}
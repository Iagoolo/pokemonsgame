package pokemonsgame.pokedex;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.encontros.EspeciePokemon;
import pokemonsgame.batalha.Registravel;

import java.util.*;

public class Pokedex implements Registravel {
  
  private List<Pokemon> capturados;
  private int[] ocorrencias = new int[EspeciePokemon.values().length];

  public Pokedex() {
    capturados = new ArrayList<>();
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
    Collections.sort(capturados);
    return capturados;
  }

  public long contarCapturasPorEspecie(EspeciePokemon pokemon) {
    return capturados.stream().filter(p -> p.getNome().equals(pokemon.getNome())).count();
  }

  public long contarVisualizacoes(EspeciePokemon pokemon) {
    return ocorrencias[pokemon.ordinal()];
  }

  public double taxaDeSucesso(EspeciePokemon pokemon) {
    long capturados =  contarCapturasPorEspecie(pokemon);

    if (ocorrencias[pokemon.ordinal()] == 0){
      System.out.println("Pokemon não visto ainda");
      return 0.0;
    }

    return ((double)capturados/ocorrencias[pokemon.ordinal()])*100;
  }

  public void removerPokemon(Pokemon pokemon) {
    capturados.remove(pokemon);
  }

  @Override
  public void registrarEncontro(Pokemon pokemon) {
    int posicaoPokemon = pokemon.getEspecie().ordinal();
    ocorrencias[posicaoPokemon]++;
  }

  @Override
  public void registrarCaptura(Pokemon pokemon) {
    capturados.add(pokemon);
  }
}
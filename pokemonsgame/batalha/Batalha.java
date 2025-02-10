package pokemonsgame.batalha;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.appscan.Scan;
import pokemonsgame.apptreinador.Treinador;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class Batalha {
  private Treinador treinador;
  private Pokemon pokemon;
  private boolean terminou = false;

  public Batalha(Treinador treinador, Pokemon pokemon) {
    this.treinador = treinador;
    this.pokemon = pokemon;
  }

  public void iniciar() {
    System.out.println("Você encontrou um " + pokemon.getNome() + "!");
    treinador.getPokedex().registrarEncontro(pokemon);
  }

  public boolean terminou() {
    return terminou;
  }

  public void proximoTurno() {

      System.out.println("Escolha uma ação:");
      System.out.println("1. Tentar Capturar");
      System.out.println("2. Fugir");

      String escolha = Scan.comandoStr();

      switch (escolha) {
        case "1":
          Pokebola pokebola = treinador.arremesarPokebola();
          boolean capturou = false;

          if (pokebola != null) {
            // Se a Pokébola não for null, tenta a captura
            capturou = tentarCaptura(pokebola);
          } 

          terminou = capturou || pokebola == null;
          break;
        case "2":
          System.out.println("Você fugiu da batalha!");
          terminou = true;
          break;
        default:
          System.out.println("Escolha inválida.");
          break;
      }
  }

  private boolean tentarCaptura(Pokebola pokebola) {
    System.out.println("Tentando capturar " + pokemon.getNome() + " com " + pokebola.getNome() + "...");

    if (pokebola.capturar(pokemon)) {
      boolean capturado = treinador.capturar(pokemon);

      if (capturado) {
        treinador.getPokedex().registrarCaptura(pokemon);
        System.out.println("Parabéns! Você capturou " + pokemon.getNome());
        terminou = true;
        return true;
      } 
      
      else {
        System.out.println("Você não tem espaço suficiente para capturar mais Pokémons.");
        terminou = true;
        return false;
      }

    } 
    
    else {
      System.out.println("A captura falhou! O Pokémon escapou.");
      terminou = true;
      return false;
    }
  }
}

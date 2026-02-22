package pokemonsgame.batalha;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.appscan.Scan;
import pokemonsgame.apptreinador.Treinador;
import pokemonsgame.pokebola.pokePA.Pokebola;

public class Batalha {
  private Treinador treinador;
  private Pokemon pokemonSelvagem;
  private Pokemon meuPokemon;
  private boolean terminou = false;

  public Batalha(Treinador treinador, Pokemon pokemonSelvagem) {
    this.treinador = treinador;
    this.pokemonSelvagem = pokemonSelvagem;

    nextLivePokemon();
  }

  public void iniciar() {
    System.out.println("\nVocê encontrou um " + pokemonSelvagem.getNome() + "!");
    treinador.getPokedex().registrarEncontro(pokemonSelvagem);
  }

  public boolean terminou() {
    return terminou;
  }

  public void proximoTurno() {

      pontosVida();

      System.out.println("\n O que o " + meuPokemon.getNome() + " deve fazer?");
      System.out.println("1. Atacar");
      System.out.println("2. Tentar Capturar");
      System.out.println("3. Fugir");

      String escolha = Scan.comandoStr();

      switch (escolha) {
        case "1":
          meuPokemon.atacar(0, pokemonSelvagem);

          if (!pokemonSelvagem.isLive()){
            System.out.println("Pokemon " + pokemonSelvagem.getNome() + " desmaiou!");
            terminou = true;
          }

          break; 

        case "2":
          Pokebola pokebola = treinador.arremesarPokebola();
          boolean capturou = false;

          // Se a Pokébola não for null, tenta a captura
          if (pokebola != null) {
            capturou = tentarCaptura(pokebola);
          } 

          terminou = capturou || pokebola == null;

          break;

        case "3":
          System.out.println("Você fugiu da batalha!");
          terminou = true;
          break;

        default:
          System.out.println("Escolha inválida.");
          break;
      }

      if (!terminou) {
        pokemonSelvagem.atacar(1, meuPokemon);

        if (!meuPokemon.isLive()){
          System.out.println("Seu pokemon desmaiou");

          nextLivePokemon();
        }
      }
  }

  private void pontosVida(){
    System.out.println();
    System.out.println(meuPokemon.getNome() + " " + meuPokemon.getHpAtual() + " HP");
    System.out.println(pokemonSelvagem.getNome() + " " + pokemonSelvagem.getHpAtual() + " HP");
  }

  private boolean nextLivePokemon(){
    this.meuPokemon = null;

    for (Pokemon p : treinador.getPokedex().listarCapturados()){
      if (p.isLive()){
        this.meuPokemon = p;

        System.out.println("--------- Vai " + meuPokemon.getNome() + " eu escolho você!!! ----------");
        System.out.println(meuPokemon.getNome() + "- " + meuPokemon.falar());
        break;
      }
    }

    if (this.meuPokemon == null){
      System.out.println("Nenhum pokemon disponível para batalha");
      this.terminou = true;
      return false;
    }

    return true;
  }

  private boolean tentarCaptura(Pokebola pokebola) {
    System.out.println("Tentando capturar " + pokemonSelvagem.getNome() + " com " + pokebola.getNome() + "...");

    if (pokebola.capturar(pokemonSelvagem)) {
      boolean capturado = treinador.capturar(pokemonSelvagem);

      if (capturado) {
        treinador.getPokedex().registrarCaptura(pokemonSelvagem);
        System.out.println("Parabéns! Você capturou " + pokemonSelvagem.getNome());

        terminou = true;

        return true;
      } else {
        System.out.println("Você não tem espaço suficiente para capturar mais Pokémons.");

        terminou = true;
        
        return false;
      }

    } else {
      System.out.println("A captura falhou! O Pokémon escapou.");
      

      return false;
    }
  }
}

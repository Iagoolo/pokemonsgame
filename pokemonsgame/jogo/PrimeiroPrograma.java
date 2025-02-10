package pokemonsgame.jogo;

import pokemonsgame.appclear.Clear;
import pokemonsgame.appmapa.Mapa;
import pokemonsgame.appscan.Scan;
import pokemonsgame.apptreinador.Treinador;
import pokemonsgame.pokedex.MenuPokedex;

public class PrimeiroPrograma {
  
  public static void main(String[] args) {
    Clear.clear();

    System.out.println("Olá, jogador, qual o seu nome?");
    
    Treinador anonymus = new Treinador("player");
    Mapa world = new Mapa(anonymus);

    System.out.println("Seja bem-vindo, " + anonymus.getNome());
    anonymus.escolherPrimeiroPokemon();

    Clear.ClearScreen();
    System.out.println("Professor Iago: ESPERE!!");
    System.out.println("Você não pode sair por aí com apenas um Pokemon, concorda?");
    System.out.println("Nessa aventura você encontrará novos amigos que precisam de um lar");
    System.out.println("Pegue essas pokebolas e capture- os");
    Clear.ClearScreen();

    for (int i = 0; i < 5; i++){
      anonymus.adicionarPokebola();
    }

    while (true) {
      Clear.ClearScreen();
        
      System.out.println();
      world.exibirMapa();
      System.out.println();
        
      System.out.println("O que você deseja fazer?");
      System.out.println("[1] Abrir Pokedéx");
      System.out.println("[2] Jogar");
      System.out.println("[3] Libertar pokemons");
      System.out.println("[4] Ver perfil");
      System.out.println("[5] Sair do game");
      
      int escolha = Scan.comandoInt();

      switch (escolha){
        case 1:
          MenuPokedex Pokedex = new MenuPokedex(anonymus.getPokedex());
          Pokedex.mostrarMenu();  
          break;
        case 2: 
          world.moverTreinador(anonymus); 
          break;
        case 3:
          anonymus.libertadorpok();
          break;
        case 4: 
          System.out.println(anonymus.toString());
          break;
        case 5:
          System.out.println("Obrigado pela aventura! Volte sempre, mestre!!");
          return;
        default:
          System.out.println("Comando inválido");
        }
      }
    }
  } 
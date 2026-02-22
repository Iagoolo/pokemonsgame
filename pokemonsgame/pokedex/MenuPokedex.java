package pokemonsgame.pokedex;

import pokemonsgame.encontros.EspeciePokemon;
import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.appscan.Scan;

public class MenuPokedex {

  private Pokedex pokedex;

  public MenuPokedex(Pokedex pokedex) {
    this.pokedex = pokedex;
  }

  private void mostrarOpcoes() {
    System.out.println("\nMenu de Pokedex");
    System.out.println("1. Mostrar Capturados");
    System.out.println("2. Mostrar Vistos");
    System.out.println("3. Detalhes sobre um pokemon");
    System.out.println("4. Voltar");
  }

  public void mostrarMenu() {
    
    String opcao;

    while(true) {
      mostrarOpcoes();

      opcao =  Scan.comandoStr();
      switch (opcao) {
        case "1":
          listarCapturados();
          break;

        case "2":
          listarVistos();
          break;

        case "3":

          System.out.println("Digite o nome do pokemon: ");
          String nomeBuscado = Scan.comandoStr();
          detalhes(nomeBuscado);
          break;

        case "4":
            System.out.println("Saindo...");
            return;
        default:
          System.out.println("Opção inválida.");
          break;
      }

    }
  }

  private void listarCapturados() {
    for (Pokemon pokemon: pokedex.listarCapturados()) {
      System.out.println(pokemon);
    }
  }

  private void listarVistos() {
    for (EspeciePokemon pokemon: pokedex.listarVistos()) {
      System.out.println(pokemon);
    }

  }

  private void detalhes(String pokemon){

    try{
      EspeciePokemon especie = EspeciePokemon.valueOf(pokemon.toUpperCase());

      long capturados = pokedex.contarCapturasPorEspecie(especie);
      double taxa = pokedex.taxaDeSucesso(especie);

      System.out.println("Você capturou " + capturados + " " + especie.getNome() + 
                         " dos " + pokedex.contarVisualizacoes(especie) + 
                         " que voce viu. Com uma taxa de captura de " + taxa + "%");

    } catch (IllegalArgumentException e){
      System.out.println("[ERRO]: O Pokémon '" + pokemon + "' não existe ou seu nome não foi digitado corretamente");
    }
  }
}
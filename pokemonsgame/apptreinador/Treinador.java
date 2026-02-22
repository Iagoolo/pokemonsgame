package pokemonsgame.apptreinador;

import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.appscan.Scan;
import pokemonsgame.encontros.EspeciePokemon;
import pokemonsgame.pokebola.pokeEA.FastBall;
import pokemonsgame.pokebola.pokeEA.FriendBall;
import pokemonsgame.pokebola.pokeEA.HealBall;
import pokemonsgame.pokebola.pokeEA.HeavyBall;
import pokemonsgame.pokebola.pokePA.Pokebola;
import pokemonsgame.pokebola.pokeTC.Greatball;
import pokemonsgame.pokebola.pokeTC.MasterBall;
import pokemonsgame.pokebola.pokeTC.UltraBall;
import pokemonsgame.pokedex.Pokedex;

import java.util.ArrayList;
import java.util.List;

public class Treinador {
    
    private String nome = "Ash"; // Nome padrão do Treinador
    private int x, y; // Coordenadas x e y do treinador
    private List<Pokebola> pokebolas; // Pokebolas do treinador
    private Pokedex pokedex; 

    public Treinador() {
        super();
        setNome();
        this.x = 0;
        this.y = 0;
        this.pokedex = new Pokedex();
        this.pokebolas = new ArrayList<>(5);
    }

    //Nome do Treinador
    public void setNome() {
        String entradaNome = Scan.name();
        if (entradaNome == null || entradaNome.trim().isEmpty()) {
            System.out.println("Nome inválido. Usando nome padrão: Ash.");
            nome = "Ash";
        } else {
            nome = entradaNome;
        }
    }

    public String getNome() {
        return nome;
    }

    //Pokemons do Treinador
    public void escolherPrimeiroPokemon() {
        System.out.println("Que maravilha! Você pode escolher seu primeiro Pokémon!");
        System.out.println("Qual deseja escolher?");
        System.out.println("[1] Charmander");
        System.out.println("[2] Bulbassauro");
        System.out.println("[3] Squirtle");

        while (true) {
            int escolha = Scan.comandoInt();

            switch (escolha) {
                case 1:
                    Pokemon charmander = new Pokemon(EspeciePokemon.CHARMANDER, 1); 
                    pokedex.registrarCaptura(charmander);
                    pokedex.registrarEncontro(charmander);
                    return;
                
                case 2:
                    Pokemon bulbassauro = new Pokemon (EspeciePokemon.BULBASAUR, 1);
                    pokedex.registrarCaptura(bulbassauro);
                    pokedex.registrarEncontro(bulbassauro);
                    return;
                
                case 3:
                    Pokemon squirtle = new Pokemon (EspeciePokemon.SQUIRTLE, 1);
                    pokedex.registrarCaptura(squirtle);
                    pokedex.registrarEncontro(squirtle);
                    return;
                
                default: System.out.println("** Comando inválido! Tente novamente **");
            }
        }
    }

    public void adicionarPokebola(){
        double chance = java.util.concurrent.ThreadLocalRandom.current().nextDouble();; // Gera um único número aleatório por iteração

        // Adiciona uma Pokebola de acordo com a chance
        if (chance < 0.2) {
            System.out.println("Pokebola Masterball adicionada");
            pokebolas.add(new MasterBall());
        } else if (chance < 0.3) {
            System.out.println("Pokebola Ultraball adicionada");
            pokebolas.add(new UltraBall());
        } else if (chance < 0.4) {
            System.out.println("Pokebola Greatball adicionada");
            pokebolas.add(new Greatball());
        } else if (chance < 0.6) {
            System.out.println("Pokebola HealBall adicionada");
            pokebolas.add(new HealBall());
        } else if (chance < 0.7) {
            System.out.println("Pokebola HeavyBall adicionada");
            pokebolas.add(new HeavyBall());
        }else if (chance < 0.9){
            System.out.println("Pokebola FriendBall adicionada");
            pokebolas.add(new FriendBall());
        }else {
            System.out.println("Pokebola FastBall adicionada");
            pokebolas.add(new FastBall());
        }
    }

    public void libertadorpok() {
        List<Pokemon> capturados = pokedex.listarCapturados();
        if (capturados.size() == 1) {
            System.out.println("VOCÊ SÓ POSSUI 1 POKEMON");
            System.out.println("VOCÊ NÃO PODE FICAR SEM SEU ÚNICO AMIGO");
            return;
        }

        System.out.println("Qual pokemon você deseja libertar?");
        System.out.println();

        for (int i = 0; i < capturados.size(); i++) {
            System.out.println("[" + i + "] " + capturados.get(i).getNome());
        }

        while (true) {
            int escolha = Scan.comandoInt();

            if (escolha >= 0 && escolha < capturados.size()) {
                pokedex.removerPokemon(capturados.get(escolha));
                System.out.println("Pokemon libertado com sucesso!");
                return;
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    public boolean capturar(Pokemon pokemon) {
        int qtdCapturados = pokedex.listarCapturados().size();

        if (qtdCapturados == 6) {
            System.out.println("Você não pode capturar mais Pokémon a menos que libere um!");
            System.out.println("Você deseja fazer isso? (S/N)");
            String opcao = Scan.comandoStr();

            if (opcao.equalsIgnoreCase("S")) {
                libertadorpok();
            } else {
                return false; // Não captura se o jogador não liberar espaço
            }
        }

        if (qtdCapturados < 6) { // Confirma que ainda há espaço após a possível liberação
            return true;
        }

        return false;
    }

    //Pokebolas do Treinador
    public Pokebola arremesarPokebola() {
        if (!temPokebola()) {
            System.out.println("Você não tem Pokébolas disponíveis!");
            return null;
        }

        return pokebolas.remove(pokebolas.size() - 1);
    }

    public boolean temPokebola() {
        return !pokebolas.isEmpty();
    }

    //Posições do Treinador
    public void setPosicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Coordenada X do treinador
    public int getX() {
        return x;
    }

    // Coordenada Y do treinador
    public int getY() {
        return y;
    }

    // Retorna a pokedex do treinador
    public Pokedex getPokedex(){
        return pokedex;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Treinador: " + nome).append("\n");
        result.append("Coordenada: (" + x + "," + y + ")" + "\n");
        result.append("Seus pokemons: \n");
        result.append(pokedex.listarCapturados().toString()).append("\n");
        
        result.append("Quantidade de pokebolas:" + pokebolas.size());
        
        return result.toString();
  }
}
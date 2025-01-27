package pokemonsgame.appmapa;

import java.util.Random;
import pokemonsgame.appclear.Clear;
import pokemonsgame.apppokemons.Pokemon;
import pokemonsgame.appscan.Scan;
import pokemonsgame.apptreinador.Treinador;
import pokemonsgame.batalha.Batalha;
import pokemonsgame.encontros.Encontro;

public class Mapa {

    private final int largura = 10; // Número de colunas
    private final int altura = 10;  // Número de linhas
    private final String[][] layout;
    private final Random random = new Random(); // Gerador de números aleatórios
    private Treinador player;

    // Construtor que recebe o treinador
    public Mapa(Treinador player) {
        this.player = player;
        layout = new String[altura][largura]; // Linhas por colunas
        inicializarMapa();
    }

    // Inicializa o mapa com '-' em todas as posições, e algumas com "w" para encontrar Pokémon
    private void inicializarMapa() {
        
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                // Adiciona "w" com cor verde ou "-" sem cor
                layout[y][x] = random.nextDouble() > 0.4 ? "w" : "-";
            }
        }
    }

    // Método de movimentação do treinador
    public void moverTreinador(Treinador treinador) {
        while (true) {
            Clear.ClearScreen();
            exibirMapa();

            System.out.println("Para onde você quer ir?");
            System.out.println("[W] Frente");
            System.out.println("[S] Atrás");
            System.out.println("[A] Esquerda");
            System.out.println("[D] Direita");
            System.out.println("[C] Configurações");

            String direcao = Scan.comandoStr().trim().toUpperCase();

            // Captura a posição atual
            int x = treinador.getX();
            int y = treinador.getY();

            // Atualiza as coordenadas com base na entrada do jogador
            switch (direcao) {
                case "W":
                    y--; // Move para cima
                    break;
                case "S":
                    y++; // Move para baixo
                    break;
                case "A":
                    x--; // Move para a esquerda
                    break;
                case "D":
                    x++; // Move para a direita
                    break;
                case "C":
                    System.out.println("Acessando configurações");
                    return; // Sai do método
                default:
                    System.out.println("*Comando Inválido*");
                    continue; // Recomeça o loop
            }

            // Valida a nova posição
            if (posicaoValida(x, y)) {
                //Atualizar a posição do jogador
                atualizarPosicao(x, y);
                
                // Verifica se ele encontra pokebolas ou pokemons nos arbustos
                arbustos();

            } else {
                System.out.println("Movimento inválido, tente novamente.");
            }
        }
    }

    // Atualiza a posição do jogador no mapa
    public void atualizarPosicao(int x, int y) {
        player.setPosicao(x, y);
    }

    // Verifica se a posição está dentro dos limites do mapa
    public boolean posicaoValida(int x, int y) {
        return (x >= 0 && x < largura && y >= 0 && y < altura);
    }

    public void arbustos(){
        // Caso um pokemon foi encontrado, uma batalha foi iniciada
        if (encontrouPokemon()){
            Pokemon encontrado = Encontro.getRandomPokemon();
                    Batalha batalha = new Batalha(player, encontrado);

                    batalha.iniciar();
                    do {
                        batalha.proximoTurno();
                    }while (batalha.terminou() != true);
        
        } else if (encontrouPokebola()){ // Caso uma pokebola foi encontrada, adiciona-a
            System.out.println("Você encontrou uma pokebola!!!");
            player.adicionarPokebola();
        }
    }

    // Verifica se uma Pokebola foi encontrada
    public boolean encontrouPokebola(){
        return layout[player.getY()][player.getX()].equals("w") && random.nextBoolean();
    }

    // Verifica se encontrou um Pokémon
    public boolean encontrouPokemon() {
        return layout[player.getY()][player.getX()].equals("w") && random.nextBoolean();
    }

    private String formatarComCor(String valor) {
        if (valor.equals("w")) {
            return "\033[32m" + valor + "\033[0m"; // Cor verde para o Pokémon
        } else {
            return valor; // Deixa o valor sem cor, como o "-" por exemplo
        }
    }
    
    // Exibe o mapa no console
    public void exibirMapa() {
        for (int i = 0; i < altura; i++) {
            System.out.print("\u001B[33m" + "| " + "\u001B[0m");
            for (int j = 0; j < largura; j++) {
                // Mostra "P" para a posição atual do jogador
                if (i == player.getY() && j == player.getX()) {
                    System.out.print(" P");
                } else {
                    System.out.print(" " + formatarComCor(layout[i][j]));
                }
            }
            System.out.println("\u001B[33m" + " |" + "\u001B[0m");
        }
    }
}

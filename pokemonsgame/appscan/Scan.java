package pokemonsgame.appscan;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {

    private static final Scanner scan = new Scanner(System.in);

    // Método para capturar o nome do jogador
    public static String name() {
        while (true) {
            try {
                System.out.print("Digite seu nome: ");
                return scan.nextLine().trim(); // Retorna a entrada sem espaços extras
            } catch (InputMismatchException e) {
                System.out.println("Nome inválido. Tente novamente.");
                scan.nextLine(); // Limpa o buffer em caso de erro
            }
        }
    }

    // Método para capturar o nome de pokémons
    public static String capturados() {
        while (true) {
            try {
                System.out.print("Digite o nome do Pokémon: ");
                return scan.nextLine().trim(); // Retorna a entrada sem espaços extras
            } catch (InputMismatchException e) {
                System.out.println("Nome inválido. Tente novamente.");
                scan.nextLine(); // Limpa o buffer em caso de erro
            }
        }
    }

    // Método para capturar uma direção (como W, A, S, D)
    public static String direcao() {
        while (true) {
            try {
                System.out.print("Digite a direção (W, A, S, D): ");
                return scan.nextLine().trim().toUpperCase(); // Normaliza a entrada
            } catch (InputMismatchException e) {
                System.out.println("Direção inválida. Tente novamente.");
                scan.nextLine(); // Limpa o buffer em caso de erro
            }
        }
    }

    // Método para capturar um comando como String
    public static String comandoStr() {
        while (true) {
            try {
                return scan.nextLine().trim(); // Retorna a entrada sem espaços extras
            } catch (InputMismatchException e) {
                System.out.println("******COMANDO INVÁLIDO******");
                scan.nextLine(); // Limpa o buffer em caso de erro
            }
        }
    }

    // Método para capturar um comando como número inteiro
    public static int comandoInt() {
        while (true) {
            try {
                int numero = scan.nextInt(); // Captura o número
                scan.nextLine(); // Limpa o buffer após ler o número
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("******COMANDO INVÁLIDO******");
                scan.nextLine(); // Limpa o buffer em caso de erro
            }
        }
    }
}


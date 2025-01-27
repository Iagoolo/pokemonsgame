package pokemonsgame.apppokemons;

import java.util.Random;

public class Pokemon {
  private String nome;
  private int nivel;
  private int maxNivel;
  private String tipo;
  private int hpBase;
  private int hpMax;
  private int hpAtual;
  private int taxaDeCaptura;
  private int ataque;
  private int defesa;
  private int velocidade;
  private int peso;
  private int amizade;
  private static final Random rand = new Random();

  public Pokemon(String nome) {
    this(nome, 1);
    ataque = (rand.nextInt(20) + 1);
    defesa = (rand.nextInt(20) + 1);
    maxNivel = rand.nextInt(100) + 1;
    peso = (rand.nextInt(32) + 1);
    velocidade = (int) ((rand.nextInt(26) + 1) / Math.max(peso, 10));
    hpBase = (rand.nextInt(15) + 1);
    hpMax = calcularHP(nivel);
    hpAtual = (int) hpMax/2;
    taxaDeCaptura = (rand.nextInt(250) + 1);
    amizade = 0;
  }
  
  public Pokemon(String nome, int nivel) {
    this(nome, nivel, 100);
  }

  public Pokemon(String nome, int nivel, int hpBase) {
    this.nome = nome;
    this.hpBase = hpBase;
    this.nivel = nivel;
    this.hpMax = calcularHP(nivel); // Nível 1
  }

  public Pokemon(String nome, int nivel, int hpBase, int taxaDeCaptura){
    this.nome = nome;
    this.hpBase = hpBase;
    this.nivel = nivel;
    this.hpMax = calcularHP(nivel);
    this.taxaDeCaptura = taxaDeCaptura;
  }

  private int calcularHP(int nivel) {
    return ((2 * hpBase * nivel) / 100) + nivel + 10;
  }

  public int getMaxNivel(){
    return maxNivel;
  }
  public int getNivel(){
    return nivel;
  }
  public String getNome() {
    return nome;
  }

  public int getPeso(){
    return peso;
  }

  public int getVelocidade(){
    return velocidade;
  }

  public int getHpAtual(){
    return hpAtual;
  }

  public int setTaxaDeCaptura(int valor){
    taxaDeCaptura += valor;
    return taxaDeCaptura;
  }
  public int getTaxaDeCaptura(){
    return taxaDeCaptura;
  }

  public int getHpMax(){
    return hpMax;
  }

  public void setAmizade(int valor){
    amizade += 200;
  }
  public String falar() {
    return nome + " " + nome;
  }

  public int curar(int pontosDeVida) {
    this.hpAtual += pontosDeVida;
    return this.hpAtual;
  }

  public void atacar(int movimento, Pokemon alvo) {
    if (taVivo()) {
      //ataque!
      System.out.println("Atacando o " + alvo + " com ataque" + movimento);
    } else {
      System.out.println("to morto :/");
    }
  }

  private boolean taVivo() {
    return this.hpAtual > 0;
  }  

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    result.append("Pokemon " + nome).append("\n");
    result.append("Nível: " + nivel + "\n");
    result.append("tipo: " + tipo + "\n");
    result.append("pontos de vida: " + hpAtual  + "/" + hpMax + "\n");
    result.append("ataque: " + ataque + "\n");
    result.append("defesa: " + defesa + "\n");
    result.append("Peso: " + peso + "\n");
    result.append("Velocidade: " + velocidade + "\n");
    result.append("Taxa de captura: " + taxaDeCaptura + "\n");
    result.append("Amizade: " + amizade + "\n");

    return result.toString();
  }
}
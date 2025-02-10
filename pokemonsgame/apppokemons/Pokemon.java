package pokemonsgame.apppokemons;

import java.util.Objects;

public class Pokemon implements Comparable<Pokemon> {
  private String nome;
  private int nivel;
  private int maxNivel;
  private String tipo;
  private int hpBase;
  private int hpMax;
  private int hpAtual;
  private double taxaDeCaptura;
  private int ataqueBase;
  private int defesaBase;
  private int velocidade;
  private double peso;
  private int amizade;
  private int experiencia;
  private Integer especie;

  public Pokemon(int especie, String nome, int hpBase, int ataque, int defesa, int velocidade, int amizade, double peso, double taxaDeCaptura) {
    this.nome = nome;
    this.nivel = 1;
    this.hpBase = hpBase;
    this.hpAtual = 5;
    this.hpMax = calcularHP(nivel);
    this.ataqueBase = ataque;
    this.defesaBase =  defesa;
    this.velocidade = velocidade;
    this.amizade = amizade;
    this.peso = peso;
    this.taxaDeCaptura = taxaDeCaptura;
    this.especie = especie;
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

  public int getEspecie(){
    return especie;
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

  public double getPeso(){
    return peso;
  }

  public int getVelocidade(){
    return velocidade;
  }

  public int getHpAtual(){
    return hpAtual;
  }

  public double setTaxaDeCaptura(int valor){
    taxaDeCaptura += valor;
    return taxaDeCaptura;
  }
  public double getTaxaDeCaptura(){
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
    result.append("ataque: " + ataqueBase + "\n");
    result.append("defesa: " + defesaBase + "\n");
    result.append("Peso: " + peso + "\n");
    result.append("Velocidade: " + velocidade + "\n");
    result.append("Taxa de captura: " + taxaDeCaptura + "\n");
    result.append("Amizade: " + amizade + "\n");
    result.append("Espécie" + especie);
    
    return result.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pokemon pokemon = (Pokemon) o;
    return especie == pokemon.especie && nivel == pokemon.nivel && hpBase == pokemon.hpBase && hpMax == pokemon.hpMax && hpAtual == pokemon.hpAtual && taxaDeCaptura == pokemon.taxaDeCaptura && velocidade == pokemon.velocidade && experiencia == pokemon.experiencia && amizade == pokemon.amizade && ataqueBase == pokemon.ataqueBase && defesaBase == pokemon.defesaBase && Double.compare(peso, pokemon.peso) == 0 && Objects.equals(nome, pokemon.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(especie, nome, nivel, hpBase, hpMax, hpAtual, taxaDeCaptura, velocidade, experiencia, amizade, ataqueBase, defesaBase, peso);
  }
  
  @Override
  public int compareTo (Pokemon p){
    return this.especie.compareTo(p.especie);
  }
}
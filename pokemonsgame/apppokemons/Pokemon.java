package pokemonsgame.apppokemons;

import java.util.Objects;
import pokemonsgame.encontros.EspeciePokemon;

public class Pokemon implements Comparable<Pokemon> {

  private EspeciePokemon especie;
  //private String tipo;
  private int nivel;
  private int maxNivel;
  private int hpMax;
  private int hpAtual;
  private int velocidade;
  private int ataqueAtual;
  private int defesaAtual;
  private int amizade;
  private int experiencia;

  public Pokemon(EspeciePokemon especiePokemon, int nivel) {
    this.nivel = nivel;
    this.especie = especiePokemon;
    this.maxNivel = 100;
    this.experiencia = 0;
    this.hpMax = calcularHP(nivel);
    this.hpAtual = this.hpMax;
    this.amizade = especiePokemon.getAmizadeBase();
    this.velocidade = calcularStatusBase(especiePokemon.getVelocidadeBase(), nivel);
    this.defesaAtual = calcularStatusBase(especiePokemon.getDefesaBase(), nivel);
    this.ataqueAtual = calcularStatusBase(especiePokemon.getAtaqueBase(), nivel);
  }

  private int calcularStatusBase(int statusBase, int nivel){
    return ((2 * statusBase * nivel) / 100) + 5;
  }

  private int calcularHP(int nivel) {
    return ((2 * especie.getHpBase() * nivel) / 100) + nivel + 10;
  }

  public int getMaxNivel(){
    return maxNivel;
  }
  public int getNivel(){
    return nivel;
  }
  public String getNome() {
    return  especie.getNome();
  }

  public double getPeso(){
    return especie.getPeso();
  }

  public int getVelocidade(){
    return velocidade;
  }

  public int getHpAtual(){
    return hpAtual;
  }

  public double getTaxaDeCaptura(){
    return especie.getTaxaDeCaptura();
  }

  public int getHpMax(){
    return hpMax;
  }

  public EspeciePokemon getEspecie(){
    return especie;
  }

  public void setAmizade(int valor){
    amizade += 200;
  }
  public String falar() {
    return especie.getNome() + " " + especie.getNome();
  }

  public int curar(int pontosDeVida) {
    this.hpAtual += pontosDeVida;
    return this.hpAtual;
  }

  public void atacar(int movimento, Pokemon alvo) {
    if (isLive()) {
      System.out.println(this.getNome() + " está atacando o " + alvo.getNome() + " com ataque" + movimento);
      alvo.receberDano(this.ataqueAtual);
    } else {
      System.out.println(getNome() + " está desmaiado");
    }
  }

  public void receberDano(int dano){
    
    dano -= defesaAtual;
    if (dano <= 0){
      dano = 1;
    }

    this.hpAtual -= dano;
    if (this.hpAtual < 0){
      this.hpAtual = 0;
    }
  }

  public boolean isLive() {
    return this.hpAtual > 0;
  }  

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    result.append("Pokemon " + especie.getNome()).append("\n");
    result.append("Nível: " + nivel + "\n");
    //result.append("tipo: " + tipo + "\n");
    result.append("pontos de vida: " + hpAtual  + "/" + hpMax + "\n");
    result.append("ataque: " + ataqueAtual + "\n");
    result.append("defesa: " + defesaAtual + "\n");
    result.append("Peso: " + especie.getPeso() + "\n");
    result.append("Velocidade: " + velocidade + "\n");
    result.append("Taxa de captura: " + especie.getTaxaDeCaptura() + "\n");
    result.append("Amizade: " + amizade + "\n");
    result.append("Espécie: " + especie);
    result.append("\n");
    
    return result.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pokemon pokemon = (Pokemon) o;
    return this.especie == pokemon.especie && 
           this.nivel == pokemon.nivel && 
           this.hpAtual == pokemon.hpAtual && 
           this.hpMax == pokemon.hpMax && 
           this.velocidade == pokemon.velocidade && 
           this.experiencia == pokemon.experiencia && 
           this.ataqueAtual == pokemon.ataqueAtual && 
           this.defesaAtual == pokemon.defesaAtual &&
           this.amizade == pokemon.amizade;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.especie, this.nivel, this.hpMax, this.hpAtual, 
                        this.velocidade, this.ataqueAtual, this.defesaAtual, 
                        this.amizade, this.experiencia);
  }
  
  @Override
  public int compareTo (Pokemon p){
    return this.especie.compareTo(p.especie);
  }
}
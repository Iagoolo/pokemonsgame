package pokemonsgame.pokebola.pokePA;

import java.util.Random;

import pokemonsgame.apppokemons.Pokemon;

public abstract class Pokebola {

  protected float bonusBall;
  protected String nome;
  private Random rand = new Random();
  
  public Pokebola (String nome, float bonusBall){
    this.nome = nome;
    this.bonusBall = bonusBall;
  }
  
  public String getNome(){
    return nome;
  }

  // Método abstrato para aplicar efeitos adicionais caso haja
  public abstract void aplicarEfeito(Pokemon pokemon);

  public float getTaxaDeCaptura(Pokemon pokemon) {
    int hpAtual = pokemon.getHpAtual();
    int hpMax = pokemon.getHpMax();
    int taxaCaptura = pokemon.getTaxaDeCaptura();
  
    return (((3 * hpMax - 2 * hpAtual) / (float)(3 * hpMax)) * bonusBall * taxaCaptura * 1); 
  }

  public boolean capturar(Pokemon p) { 
    aplicarEfeito(p);
    float chance = getTaxaDeCaptura(p);
    System.out.printf("Você possui %.2f%% de chance de capturar\n", getTaxaDeCaptura(p) * 0.4);
    return rand.nextInt(1 , 255) < chance; 
  }
}
package pokemonsgame.pokebola.pokePA;

import java.util.concurrent.ThreadLocalRandom;

import pokemonsgame.apppokemons.Pokemon;

public abstract class Pokebola {

  protected float bonusBall;
  protected String nome;
  
  public Pokebola (String nome, float bonusBall){
    this.nome = nome;
    this.bonusBall = bonusBall;
  }
  
  public String getNome(){
    return nome;
  }

  // Método abstrato para aplicar efeitos adicionais caso haja antes da captura
  public abstract void aplicarEfeito(Pokemon pokemon);

  public void aplicarEfeitoPosCaptura(Pokemon pokemon){}

  protected double getTaxaDeCaptura(Pokemon pokemon) {
    return ((3f * pokemon.getHpMax() - 2 * pokemon.getHpAtual()) / (3*pokemon.getHpMax())
            * pokemon.getTaxaDeCaptura() * bonusBall);
  }

  public boolean capturar(Pokemon p) {
    aplicarEfeito(p);

    double chance = getTaxaDeCaptura(p);
    System.out.println("Você tem " + (chance/255f)*100 + "% para capturar o pokemon");
    
    double sorteio = ThreadLocalRandom.current().nextInt(256);
    
    boolean sucesso =  sorteio < chance;

    if (sucesso){
      aplicarEfeito(p);
    }

    return sucesso;
  }

}
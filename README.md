# ⚡ Pokémon Game (Terminal RPG)

Este projeto foi desenvolvido durante as aulas de Programação Orientada a Objetos (POO), com o intuito de colocar em prática os conceitos fundamentais da disciplina.

Esse jogo não possui um sistema idêntico ao original, mas traz as principais mecânicas clássicas da franquia adaptadas para uma experiência interativa no terminal.

## 🎮 Funcionalidades

* **Exploração de Mapa:** Navegação 2D pelo terminal com encontros aleatórios (grama alta).
* **Batalhas em Turnos:** Sistema de combate de RPG com HUD de vida, ataques baseados em status (Ataque/Defesa) e sistema de nocaute.
* **Sistema de Captura:** Diferentes tipos de Pokébolas, com taxas de sucesso que dependem da vida atual do Pokémon selvagem.
* **Gerenciamento de Equipe:** Pokédex integrada e troca automática de Pokémons caso um membro da equipe desmaie.

## 💻 Tecnologias e Conceitos

* **Linguagem:** Java
* **Conceitos de POO aplicados:**
  * Encapsulamento (proteção de atributos como HP e Status)
  * Herança e Polimorfismo (diferentes tipos de Pokébolas)
  * Princípio DRY (código limpo e reutilizável)
  * Padrão de Projeto Flyweight (para otimização de memória dos status base dos Pokémons)

## 🚀 Como Executar

1.Clone este repositório:

```bash
git clone [https://github.com/Iagoolo/pokemonsgame.git](https://github.com/Iagoolo/pokemonsgame.git)
```

2.Abra o projeto na sua IDE de preferência (VSCode, IntelliJ, Eclipse, etc.).

3.Compile e execute a classe principal (que contém o método main) para iniciar o jogo no terminal.

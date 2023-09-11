package com.example.finalproject;

/**
 * Representa um herói no jogo.
 * O herói ataca lançando dois dados e escolhe o valor mais alto.
 */
public abstract class Heroi extends Personagem {

    public Heroi(String nome, int vida, int armadura) {
        super(nome, vida, armadura);
    }
    // Ataca lançando dois dados e retorna o maior valor.
    //@return Valor do ataque
    @Override
    public int atacar() {
        int dado1 = (int) (Math.random() * 101);
        int dado2 = (int) (Math.random() * 101);
        return Math.max(dado1, dado2);

    }
}

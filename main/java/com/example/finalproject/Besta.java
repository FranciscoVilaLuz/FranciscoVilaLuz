package com.example.finalproject;

public abstract class Besta extends Personagem {
    /**
     * Representa uma besta ou inimigo no jogo.
     * As bestas atacam com um dado de 0 a 90.
     */
    public Besta(String nome, int vida, int armadura) {
        super(nome, vida, armadura);
    }
    //Ataca gerando um valor aleatório de 0 a 90.
    //* @return Valor do ataque
    @Override
    public int atacar() {
        return (int) (Math.random() *91);
    }
}

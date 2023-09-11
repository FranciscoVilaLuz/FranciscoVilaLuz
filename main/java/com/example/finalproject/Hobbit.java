package com.example.finalproject;

public class Hobbit extends Heroi {
    public Hobbit (String nome, int vida, int armadura){
        super(nome, vida, armadura);
    }

    @Override
    public int atacar() {
        int ataque= super.atacar();
        return ataque -5;
    }
}
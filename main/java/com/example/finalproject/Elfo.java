package com.example.finalproject;

public class Elfo extends Heroi {

    public Elfo (String nome, int vida, int armadura){
        super (nome, vida, armadura);
    }
    @Override
    public int atacar() {
        int ataque = super.atacar();
        return ataque + 10;
    }
}

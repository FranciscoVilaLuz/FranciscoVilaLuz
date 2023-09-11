package com.example.finalproject;

public class Orque extends Besta {

    public Orque(String nome, int vida, int armadura){
        super(nome, vida, armadura);
    }
    @Override
    public void defender( int ataque){
        int defesa = (int) (this.armadura *0.9);
        int dano=  ataque -defesa;
        if (dano >0){
            this.vida -= dano;
            if (this.vida <0) this.vida=0;
        }
    }
}
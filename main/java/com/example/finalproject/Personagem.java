package com.example.finalproject;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int armadura;

    public Personagem(String nome, int vida, int armadura) {
        this.nome = nome;
        this.vida = Math.max(vida, 0); // Garantindo que a vida não seja negativa
        this.armadura = Math.max(armadura, 0); // Garantindo que a armadura não seja negativa
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getArmadura() {
        return armadura;
    }
    // Representação em String do Personagem para impressão
    @Override
    public String toString() {
        return nome + " (Vida=" + vida + " Armadura=" + armadura + ")";
    }

    public abstract int atacar();

    public void defender(int ataque){
        int dano= ataque - this.armadura;
        if (dano > 0){
            this.vida -=dano;
            if (this.vida < 0) this.vida=0;
        }
    }
    public boolean estaVivo(){
        return this.vida >0;
    }


}



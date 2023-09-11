package com.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    private List<Personagem> exercitoHerois;
    private List<Personagem> exercitoBestas;


    public Tabuleiro(List<Personagem> exercitoHerois, List<Personagem> exercitoBestas) {
        this.exercitoHerois = exercitoHerois;
        this.exercitoBestas = exercitoBestas;

    }

    public void realizarBatalha() {
        int turno = 1;

        while (!todosMortos(exercitoHerois) && !todosMortos(exercitoBestas)) {
            System.out.println("Turno " + turno + ":");
            turno++;

            for (int i = 0; i < Math.min(exercitoHerois.size(), exercitoBestas.size()); i++) {
                Personagem heroi = exercitoHerois.get(i);
                Personagem besta = exercitoBestas.get(i);

                if (heroi.estaVivo() && besta.estaVivo()) {
                    System.out.println("Luta entre " + heroi.getNome() + " (Vida=" + heroi.getVida() + " Armadura=" + heroi.getArmadura() + ") e "
                            + besta.getNome() + " (Vida=" + besta.getVida() + " Armadura=" + besta.getArmadura() + ")");

                    int ataqueHeroi = heroi.atacar();
                    int danoHeroi = ataqueHeroi - besta.getArmadura();
                    danoHeroi = danoHeroi > 0 ? danoHeroi : 0;

                    besta.defender(ataqueHeroi);

                    if (besta.estaVivo()) {
                        int ataqueBesta = besta.atacar();
                        int danoBesta = ataqueBesta - heroi.getArmadura();
                        danoBesta = danoBesta > 0 ? danoBesta : 0;

                        System.out.println(besta.getNome() + " saca " + ataqueBesta + " e tira " + danoBesta + " de vida a " + heroi.getNome());
                        heroi.defender(ataqueBesta);
                    } else {
                        System.out.println("Morre o " + nomeTipo(besta) + " " + besta.getNome() + "!");
                    }

                    if (!heroi.estaVivo()) {
                        System.out.println("Morre o " + nomeTipo(heroi) + " " + heroi.getNome() + "!");
                    }
                }
            }
        }

        if (todosMortos(exercitoHerois)) {
            System.out.println("As bestas venceram a batalha!");
        } else if (todosMortos(exercitoBestas)) {
            System.out.println("Os heróis venceram a batalha!");
        } else {
            System.out.println("A batalha acabou empatada!");
        }
    }


    private static boolean todosMortos(List<Personagem> persoangens) {
        for (Personagem personagem : persoangens) {
            if (personagem.estaVivo()) {
                return false;
            }
        }
        return true;
    }

    private String nomeTipo(Personagem personagem) {
        if (personagem instanceof Elfo) return "elfo";
        if (personagem instanceof Hobbit) return "hobbit";
        if (personagem instanceof Humano) return "humano";
        if (personagem instanceof Orque) return "orque";
        if (personagem instanceof Troll) return "troll";
        return "desconhecido";
    }
}

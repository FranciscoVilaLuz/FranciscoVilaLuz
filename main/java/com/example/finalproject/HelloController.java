package com.example.finalproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private List<Personagem> personagens = new ArrayList<>();
    private List<Personagem> exercitoHerois;
    private List<Personagem> exercitoBestas;
    private ObservableList<String> herois = FXCollections.observableArrayList();
    private ObservableList<String> bestas = FXCollections.observableArrayList();
    private ObservableList<String> resultadosLuta = FXCollections.observableArrayList();

    @FXML
    private ListView<String> bestaList;

    @FXML
    private Button bestasAdicionar;

    @FXML
    private TextField bestasArmadura;

    @FXML
    private TextField bestasNome;

    @FXML
    private ChoiceBox<String> bestasTipo;

    @FXML
    private TextField bestasVida;

    @FXML
    private Button descerBtn;

    @FXML
    private Button descerbtn;

    @FXML
    private Button eliminarBotton;

    @FXML
    private Button eliminarBtn;

    @FXML
    private ListView<String> heroiList;

    @FXML
    private Button heroisAdicionar;

    @FXML
    private TextField heroisArmardura;

    @FXML
    private TextField heroisNome;

    @FXML
    private ChoiceBox<String> heroisTipo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        heroisTipo.getItems().addAll("Elfo", "Humano", "Hobbit");
        bestasTipo.getItems().addAll("Troll", "Orque");
        exercitoHerois = new ArrayList<>();
        exercitoBestas = new ArrayList<>();
        lutaList.setItems(resultadosLuta);
    }

    @FXML
    private TextField heroisVida;

    @FXML
    private Button lutaBtn;

    @FXML
    private ListView<String> lutaList;

    @FXML
    void SubirBestas(ActionEvent event) {
        int selectedIndex = bestaList.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            String selectedItem = bestas.remove(selectedIndex);
            bestas.add(selectedIndex - 1, selectedItem);
            bestaList.getSelectionModel().select(selectedIndex - 1);
        }
    }

    @FXML
    void SubirHerois(ActionEvent event) {
        int selectedIndex = heroiList.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            String selectedItem = herois.remove(selectedIndex);
            herois.add(selectedIndex - 1, selectedItem);
            heroiList.getSelectionModel().select(selectedIndex - 1);
        }
    }

    @FXML
    void descerBestas(ActionEvent event) {
        int selectedIndex = bestaList.getSelectionModel().getSelectedIndex();
        if (selectedIndex < bestas.size() - 1 && selectedIndex != -1) {
            String selectedItem = bestas.remove(selectedIndex);
            bestas.add(selectedIndex + 1, selectedItem);
            bestaList.getSelectionModel().select(selectedIndex + 1);
        }
    }

    @FXML
    void descerHerois(ActionEvent event) {
        int selectedIndex = heroiList.getSelectionModel().getSelectedIndex();
        if (selectedIndex < herois.size() - 1 && selectedIndex != -1) {
            String selectedItem = herois.remove(selectedIndex);
            herois.add(selectedIndex + 1, selectedItem);
            heroiList.getSelectionModel().select(selectedIndex + 1);
        }
    }

    @FXML
    void eliminarBestas(ActionEvent event) {
        int selectedIndex = bestaList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            bestas.remove(selectedIndex);
            bestaList.getItems().remove(selectedIndex);
        }
    }

    @FXML
    void eliminarHerois(ActionEvent event) {
        int selectedIndex = heroiList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            herois.remove(selectedIndex);
            heroiList.getItems().remove(selectedIndex);
        }
    }

    @FXML
    void fazerAdicionarBestas(ActionEvent event) {
        String nome = bestasNome.getText();
        String tipo = bestasTipo.getValue();
        int vida = Integer.parseInt(bestasVida.getText().isEmpty() ? "0" : bestasVida.getText());
        int armadura = Integer.parseInt(bestasArmadura.getText().isEmpty() ? "0" : bestasArmadura.getText());

        Personagem besta = null;
        switch (tipo) {
            case "Troll":
                besta = new Troll(nome, vida, armadura);
                break;
            case "Orque":
                besta = new Orque(nome, vida, armadura);
                break;
        }

        if (besta != null) {
            exercitoBestas.add(besta);
            String bestaString = nome + " - " + tipo + " - Vida: " + vida + " - Armadura: " + armadura;
            bestas.add(bestaString);
            bestaList.setItems(bestas);
        }

        bestasNome.clear();
        bestasTipo.getSelectionModel().clearSelection();
        bestasVida.clear();
        bestasArmadura.clear();
    }

    @FXML
    void fazerAdicionarHerois(ActionEvent event) {
        String nome = heroisNome.getText();
        String tipo = heroisTipo.getValue();
        int vida = Integer.parseInt(heroisVida.getText());
        int armadura = Integer.parseInt(heroisArmardura.getText());

        Personagem heroi = null;
        switch (tipo) {
            case "Elfo":
                heroi = new Elfo(nome, vida, armadura);
                break;
            case "Humano":
                heroi = new Humano(nome, vida, armadura);
                break;
            case "Hobbit":
                heroi = new Hobbit(nome, vida, armadura);
                break;
        }

        if (heroi != null) {
            exercitoHerois.add(heroi);
            String heroiString = nome + " - " + tipo + " - Vida: " + vida + " - Armadura: " + armadura;
            herois.add(heroiString);
            heroiList.setItems(herois);
        }

        heroisNome.clear();
        heroisTipo.getSelectionModel().clearSelection();
        heroisVida.clear();
        heroisArmardura.clear();
    }

    @FXML
    void lutaFinal(ActionEvent event) {
        int turno = 1;
        int maxTurnos = 100; // Define um número máximo de turnos para a luta.

        while (!todosMortos(exercitoHerois) && !todosMortos(exercitoBestas) && turno <= maxTurnos) {
            System.out.println("Turno " + turno + ":");
            resultadosLuta.add("Turno " + turno + ":");
            turno++;

            for (int i = 0; i < Math.min(exercitoHerois.size(), exercitoBestas.size()); i++) {
                Personagem heroi = exercitoHerois.get(i);
                Personagem besta = exercitoBestas.get(i);

                if (heroi.estaVivo() && besta.estaVivo()) {
                    System.out.println("Luta entre " + heroi + " e " + besta);
                    resultadosLuta.add("Luta entre " + heroi + " e " + besta);

                    int ataqueHeroi = heroi.atacar();
                    besta.defender(ataqueHeroi);
                    System.out.println(heroi.getNome() + " retira " + ataqueHeroi + " e tira " + (ataqueHeroi - besta.getArmadura()) + " de vida a " + besta.getNome());
                    resultadosLuta.add(heroi.getNome() + " retira " + ataqueHeroi + " e tira " + (ataqueHeroi - besta.getArmadura()) + " de vida a " + besta.getNome());


                    int ataqueBesta = besta.atacar();
                    heroi.defender(ataqueBesta);
                    System.out.println(besta.getNome() + " retira " + ataqueBesta + " e tira " + (ataqueBesta - heroi.getArmadura()) + " de vida a " + heroi.getNome());
                    resultadosLuta.add(besta.getNome() + " retira " + ataqueBesta + " e tira " + (ataqueBesta - heroi.getArmadura()) + " de vida a " + heroi.getNome());

                    if (!heroi.estaVivo()) {
                        System.out.println("Morre o herói " + heroi.getNome() + "!");
                        resultadosLuta.add("Morre o herói " + heroi.getNome() + "!");
                    }
                    if (!besta.estaVivo()) {
                        System.out.println("Morre a besta " + besta.getNome() + "!");
                        resultadosLuta.add("Morre a besta " + besta.getNome() + "!");
                    }
                }
            }
        }

        if (todosMortos(exercitoHerois)) {
            System.out.println("As bestas venceram a batalha!");
            resultadosLuta.add("As bestas venceram a batalha!");
        } else if (todosMortos(exercitoBestas)) {
            System.out.println("Os heróis venceram a batalha!");
            resultadosLuta.add("Os heróis venceram a batalha!");
        } else {
            System.out.println("A batalha acabou empatada!");
            resultadosLuta.add("A batalha acabou empatada!");
        }
        lutaList.setItems(resultadosLuta);
    }

    private boolean todosMortos(List<Personagem> exercito) {
        for (Personagem p : exercito) {
            if (p.estaVivo()) {
                return false;
            }
        }
        return true;
    }
}

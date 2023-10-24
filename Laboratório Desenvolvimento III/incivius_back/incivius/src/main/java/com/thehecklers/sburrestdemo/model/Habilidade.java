package main.java.com.thehecklers.sburrestdemo.model;

import java.util.ArrayList;

public class Habilidade {
    private ArrayList<String> habilidade;
    private String descricao;

    public Habilidade() {
        // Construtor vazio
    }

    // Métodos Getters e Setters

    public ArrayList<String> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(ArrayList<String> habilidade) {
        this.habilidade = habilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

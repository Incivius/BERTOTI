package com.thehecklers.sburrestdemo.model;

public class Experiencia {
    private String nome;
    private int ano;
    private int durationMeses;
    private String descricao;

    public Experiencia() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataInicio() {
        return ano;
    }

    public void setDataInicio(int ano) {
        this.ano = ano;
    }

    public int getDurationMeses() {
        return durationMeses;
    }

    public void setDurationMeses(int durationMeses) {
        this.durationMeses = durationMeses;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

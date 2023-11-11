package com.thehecklers.sburrestdemo.model;

import java.util.ArrayList;

public class Projeto {
    private String nome;
    private String link;
    private ArrayList<String> tagsStack;
    private String descricao;

    public Projeto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<String> getTagsStack() {
        return tagsStack;
    }

    public void setTagsStack(ArrayList<String> tagsStack) {
        this.tagsStack = tagsStack;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

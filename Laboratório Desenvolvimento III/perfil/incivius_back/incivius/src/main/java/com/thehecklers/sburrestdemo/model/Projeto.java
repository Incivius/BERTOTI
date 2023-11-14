package com.thehecklers.sburrestdemo.model;

public class Projeto {
    private String nome;
    private String link;
    private String tagsStack;
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

    public String getTagsStack() {
        return tagsStack;
    }

    public void setTagsStack(String tagsStack) {
        this.tagsStack = tagsStack;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

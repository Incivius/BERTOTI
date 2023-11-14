package com.thehecklers.sburrestdemo.model;

public class Perfil {
    private String nome;
    private String dataNascimento;
    private String sobre;
    private String email;
    private Projeto projeto;
    private Experiencia experiencia;
    private Habilidade habilidade;

    public Perfil(String nome, String dataNascimento, String sobre, String email, Projeto projeto,
            Experiencia experiencia, Habilidade habilidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sobre = sobre;
        this.email = email;
        this.projeto = projeto;
        this.experiencia = experiencia;
        this.habilidade = habilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }
}

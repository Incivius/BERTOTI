package main.java.com.thehecklers.sburrestdemo.model;
import java.util.Date;
import main.java.com.thehecklers.sburrestdemo.model.Experiencia;
import main.java.com.thehecklers.sburrestdemo.model.Habilidade;
import main.java.com.thehecklers.sburrestdemo.model.Projeto;

public class Perfil {
    private String nome;
    private Date dataNascimento;
    private String sobre;
    private String email;
    private Projeto projeto;
    private Experiencia experiencia;
    private Habilidade habilidade;

    public Perfil() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

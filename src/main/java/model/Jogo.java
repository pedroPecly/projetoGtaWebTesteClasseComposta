package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private Boolean zerado;

    public Jogo() {
    }

    public Jogo(String nome, Boolean zerado) {
        this.nome = nome;
        this.zerado = zerado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getZerado() {
        return zerado;
    }

    public void setZerado(Boolean zerado) {
        this.zerado = zerado;
    }

}

package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String senha;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "perfil_jogos",
        joinColumns = @JoinColumn(name = "perfil_id"),
        inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private List<Jogo> jogosFavoritos;

    public Perfil(String nome, String senha, String cpf, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Perfil() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Jogo> getJogosFavoritos() {
        return jogosFavoritos;
    }

    public void setJogosFavoritos(List<Jogo> jogosFavoritos) {
        this.jogosFavoritos = jogosFavoritos;
    }

    
}

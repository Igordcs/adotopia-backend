package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String telefone;
    private String email;
    @OneToOne(cascade=CascadeType.ALL)
    private Endereco endereco;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Animal> meusPets;
    private String descricao;

    public Usuario(String nome, String telefone, String email, Endereco endereco, String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.descricao = descricao;
        this.meusPets = null;
    }

    public Usuario() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Endereco getEndereco(){
        return this.endereco;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public List<Animal> getMeusPets() {
        return this.meusPets;
    }

    public void setMeusPets(List<Animal> meusPets) {
        this.meusPets = meusPets;
    }

}

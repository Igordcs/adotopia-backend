package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String avatar;
    @ManyToOne
    @JoinColumn(name = "dono_id")
    private Usuario dono;
    private List<String> fotos;    
    private List<String> comportamentos;
    private Especie especie;
    private boolean vermifugado;
    private boolean vacinado;
    private boolean castrado;
    private String raca;
    private String porte;
    private String descricao;
    private float idade;
    private Status status = Status.DISPONIVEL;

    public Animal(String name, String avatar, Usuario dono, List<String> fotos, List<String> comportamentos, Especie especie, boolean vermifugado, boolean vacinado, boolean castrado, String raca, String porte, String descricao, float idade) {
        super();
        this.name = name;
        this.dono = dono;
        this.avatar = avatar;
        this.fotos = fotos;
        this.comportamentos = comportamentos;
        this.especie = especie;
        this.vermifugado = vermifugado;
        this.vacinado = vacinado;
        this.castrado = castrado;
        this.raca = raca;
        this.porte = porte;
        this.descricao = descricao;
        this.idade = idade;
    }

    public Animal() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Usuario getDono() {
        return this.dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public List<String> getFotos(){
        return this.fotos;
    }
    public void setFotos(List<String> fotos){
        this.fotos = fotos;
    }
    public List<String> getComportamentos(){
        return this.comportamentos;
    }
    public void setComportamentos(List<String> comportamentos){
        this.comportamentos = comportamentos;
    }
    public Especie getEspecie() {
        return this.especie;
    }
    public boolean getVermifugado() {
        return this.vermifugado;
    }
    public void setVermifugado(boolean vermifugado) {
        this.vermifugado = vermifugado;
    }
    public boolean getVacinado() {
        return this.vacinado;
    }
    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }
     public boolean getCastrado() {
        return this.castrado;
    }
    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return this.raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getPorte() {
        return this.porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getIdade() {
        return this.idade;
    }
    public void setIdade(float idade) {
        this.idade = idade;
    }
       
    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
       
}

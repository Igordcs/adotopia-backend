package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Usuario adotante;
    @OneToOne
    private Usuario doador;
    private Date data;
    private String protocolo;
    @OneToOne
    private Animal animal;

    public Registro(Usuario adotante, Usuario doador, Date data, String protocolo, Animal animal) {
        super();
        this.adotante = adotante;
        this.doador = doador;
        this.data = data;
        this.protocolo = protocolo;
        this.animal = animal;
    }

    public Registro() {
        super();
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Usuario getAdotante() {
        return this.adotante;
    }
    public void setAdotante(Usuario adotante) {
        this.adotante = adotante;
    }
    public Usuario getDoador() {
        return this.doador;
    }
    public void setDoadorId(Usuario doador) {
        this.doador = doador;
    }

    public Date getData() {
        return this.data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public String getProtocolo() {
        return this.protocolo;
    }
    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Animal getAnimal() {
        return this.animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


}

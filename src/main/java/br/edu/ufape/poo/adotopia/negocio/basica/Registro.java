package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String adotante;
    private String doador;

    private Date data;
    private String protocolo;

    public Registro(String adotante, String doador, Date data, String protocolo) {
        super();
        this.adotante = adotante;
        this.doador = doador;
        this.data = data;
        this.protocolo = protocolo;
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

    public String getAdotante() {
        return this.adotante;
    }
    public void setAdotante(String adotante) {
        this.adotante = adotante;
    }
    public String getDoador() {
        return this.doador;
    }
    public void setDoador(String doador) {
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


}

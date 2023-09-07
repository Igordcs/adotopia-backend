package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long adotanteId;
    private Long doadorId;
    private Status status;
    private Date data;
    private String protocolo;

    public Registro(Long adotanteId, Long doadorId, Status status, Date data, String protocolo) {
        super();
        this.adotanteId = adotanteId;
        this.doadorId = doadorId;
        this.status = status;
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

    public Long getAdotanteId() {
        return this.adotanteId;
    }
    public void setAdotanteId(Long adotanteId) {
        this.adotanteId = adotanteId;
    }
    public Long getDoadorId() {
        return this.doadorId;
    }
    public void setDoadorId(Long doadorId) {
        this.doadorId = doadorId;
    }
    
    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status = status;
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

package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String conteudoMsg;
    private Long destinatarioId;
    private Long remetenteId;
    private Date data;

    public Mensagem(String conteudoMsg, Long destinatarioId, Long remetenteId, Date data) {
        super();
        this.conteudoMsg = conteudoMsg;
        this.destinatarioId = destinatarioId;
        this.remetenteId = remetenteId;
        this.data = data;
    }

    public Mensagem() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getDestinatarioId() {
        return this.destinatarioId;
    }
    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }
    public String getConteudoMsg() {
        return conteudoMsg;
    }
    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }
    public Long getRemetenteId() {
        return this.remetenteId;
    }
    public void setRemetenteId(Long remetenteId) {
        this.remetenteId = remetenteId;
    }
    public Date getData() {
        return this.data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}

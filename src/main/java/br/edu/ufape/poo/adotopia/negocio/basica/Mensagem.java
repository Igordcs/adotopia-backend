package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String conteudoMsg;
    private String destinatario;
    private String remetente;
    private Date data;

    public Mensagem(String conteudoMsg, String destinatario, String remetente, Date data) {
        super();
        this.conteudoMsg = conteudoMsg;
        this.destinatario = destinatario;
        this.remetente = remetente;
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

    public String getDestinatario() {
        return this.destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getConteudoMsg() {
        return conteudoMsg;
    }
    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }
    public String getRemetente() {
        return this.remetente;
    }
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
    public Date getData() {
        return this.data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}

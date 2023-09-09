package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String conteudoMsg;
    private Date data;
    @ManyToOne
    private Usuario remetenteUsuario;

    public Mensagem(String conteudoMsg, Usuario remetenteUsuario, Date data) {
        super();
        this.conteudoMsg = conteudoMsg;
        this.data = data;
        this.remetenteUsuario = remetenteUsuario;
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

    public Usuario getRemetenteUsuario(){
        return remetenteUsuario;
    }

    public void setRemetenteUsuario(Usuario remetenteUsuario){
        this.remetenteUsuario = remetenteUsuario;
    }

    public String getConteudoMsg() {
        return conteudoMsg;
    }
    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }

    public Date getData() {
        return this.data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}

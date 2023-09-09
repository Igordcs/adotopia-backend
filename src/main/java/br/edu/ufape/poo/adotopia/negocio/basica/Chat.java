package br.edu.ufape.poo.adotopia.negocio.basica;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario destinatario;
    @OneToOne
    private Usuario remetente;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List <Mensagem> mensagens = new ArrayList<>();

    public Chat (Usuario destinatario, Usuario remetente){
        super();
        this.destinatario = destinatario;
        this.remetente = remetente;
    }

    public Chat (){
        super();
    }
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getDestinatario() {
        return this.destinatario;
    }
    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Usuario getRemetente() {
        return this.remetente;
    }
    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public List <Mensagem> getMensagens(){
        return this.mensagens;
    }

    public void setMensagens(List <Mensagem> mensagens){
        this.mensagens = mensagens;
    }

}

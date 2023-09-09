package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.IntefaceColecaoChat;
import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoMensagem;
import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoUsuario;
import br.edu.ufape.poo.adotopia.negocio.basica.Chat;
import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;

@Service
public class CadastroMensagem {
    @Autowired
    IntefaceColecaoChat colecaoChat;
    @Autowired
    InterfaceColecaoUsuario colecaoUsuario;
    @Autowired
    InterfaceColecaoMensagem colecaoMensagem;

    public Mensagem enviarMensagem(Mensagem mensagem, Long chatId, Long remetenteId){
      Chat chat = colecaoChat.findById(chatId).orElseThrow(() -> new NoSuchElementException("Chat não encontrado"));
      Usuario usuario = colecaoUsuario.findById(remetenteId).orElseThrow(() -> new NoSuchElementException("Remetente não encontrado"));
      mensagem.setRemetenteUsuario(usuario);
      chat.getMensagens().add(mensagem);
      colecaoChat.saveAndFlush(chat);
      colecaoMensagem.save(mensagem);
      return mensagem;
    }

}

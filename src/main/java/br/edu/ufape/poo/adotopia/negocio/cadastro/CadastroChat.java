package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.IntefaceColecaoChat;
import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoUsuario;
import br.edu.ufape.poo.adotopia.negocio.basica.Chat;
import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;

@Service
public class CadastroChat implements InterfaceCadastroChat {

    @Autowired
    private IntefaceColecaoChat colecaoChat;
    @Autowired
    private InterfaceColecaoUsuario colecaoUsuario;

    public List<Chat> listarTodosChats(){
      return colecaoChat.findAll();
    }

    public List<Chat> listarChatsId(Long id) {
		  return colecaoChat.findAllByRemetenteIdOrDestinatarioId(id, id);
    }

    public Chat criarChat(Long remetenteId, Long destinatarioId){
      Usuario remetente = colecaoUsuario.findById(remetenteId).orElseThrow(() -> new NoSuchElementException("remetente não encontrado"));
      Usuario destinatario = colecaoUsuario.findById(destinatarioId).orElseThrow(() -> new NoSuchElementException("destinatario não encontrado"));
      
      Chat chat = new Chat(remetente, destinatario);
      return colecaoChat.save(chat);
    }
	}



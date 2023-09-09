package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Chat;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.ChatJaCriadoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private Fachada fachada;

    @GetMapping("/listar")
    public List<Chat> listarTodosChats(){
        return fachada.listarTodosChats();
    }

    @GetMapping("/listar/{id}")
    public List<Chat> listarChatsId(@PathVariable Long id) {
        return fachada.listarChatsId(id);
    }

    @PostMapping("/{remetenteId}/{destinatarioId}")
    public Chat criarChat(@PathVariable Long remetenteId, @PathVariable Long destinatarioId) throws NoSuchElementException, ChatJaCriadoException{
        return fachada.criarChat(remetenteId, destinatarioId);
    }

}

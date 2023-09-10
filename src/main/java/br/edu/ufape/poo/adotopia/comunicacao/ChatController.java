package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Chat>> listarTodosChats(){
        return new ResponseEntity<List<Chat>>(fachada.listarTodosChats(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
     public ResponseEntity<List<Chat>> listarChatsId(@PathVariable Long id) {
        return new ResponseEntity<List<Chat>>(fachada.listarChatsId(id), HttpStatus.OK);
    }

    @PostMapping("/{remetenteId}/{destinatarioId}")
public ResponseEntity<?> criarChat(@PathVariable Long remetenteId, @PathVariable Long destinatarioId) throws ChatJaCriadoException, NoSuchElementException {
    try {
        return new ResponseEntity<Chat>(fachada.criarChat(remetenteId, destinatarioId), HttpStatus.CREATED);
    } catch (ChatJaCriadoException e) {
        Map<String, String> response = new HashMap<>();
        response.put("erro", "Chat já foi criado.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    } catch (NoSuchElementException e) {
        Map<String, String> response = new HashMap<>();
        response.put("erro", "Usuário não encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

    
}
package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private Fachada fachada;

  

    @PostMapping("/enviar/{chatId}/{remetenteId}")
    public ResponseEntity<Mensagem> enviarMensagem(@RequestBody Mensagem mensagem, @PathVariable Long chatId, @PathVariable Long remetenteId){
        return new ResponseEntity<Mensagem>( fachada.enviarMensagem(mensagem, chatId, remetenteId), HttpStatus.CREATED );
        
    }
}

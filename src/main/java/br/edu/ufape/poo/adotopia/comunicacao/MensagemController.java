package br.edu.ufape.poo.adotopia.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private Fachada fachada;

    @PostMapping("/enviar/{chatId}/{remetenteId}")
    public Mensagem enviarMensagem(@RequestBody Mensagem mensagem, @PathVariable Long chatId, @PathVariable Long remetenteId){
        return fachada.enviarMensagem(mensagem, chatId, remetenteId);
    }
}

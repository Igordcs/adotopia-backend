package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/todas")
    public List<Mensagem> listarTodasMensagens(){
        return fachada.listarTodasMensagens();
    }

    @GetMapping("/{id}")
    public List<Mensagem> listarMensagensRemetente(@PathVariable Long id) {
        return fachada.listarMensagensRemetente(id);
    }

    @PostMapping("/enviar")
    public Mensagem enviarMensagem(@RequestBody Mensagem mensagem){
        return fachada.enviarMensagem(mensagem);
    }

    @DeleteMapping("/deletar/{id}")
    public Mensagem deletarMensagem(@PathVariable Long id){
        return fachada.deletarMensagem(id);
    }
}

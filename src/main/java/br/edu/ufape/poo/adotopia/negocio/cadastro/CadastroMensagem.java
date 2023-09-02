package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.IntefaceColecaoMensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;

@Service
public class CadastroMensagem implements InterfaceCadastroMensagem {

    @Autowired
    private IntefaceColecaoMensagem colecaoMensagem;

    public List<Mensagem> listarTodasMensagens(){
      return colecaoMensagem.findAll();
    }

    public List<Mensagem> listarMensagensRemetente(Long id) {
		  return colecaoMensagem.findAllByRemetenteId(id);
    }

    public Mensagem enviarMensagem(Mensagem entity){
      return colecaoMensagem.save(entity);
    }

    public Mensagem deletarMensagem(Long id){
      Mensagem mensagem = colecaoMensagem.findById(id).orElse(null);

      if(mensagem == null)
        return null;

      
      colecaoMensagem.delete(mensagem);
      return mensagem;

    }

	}



package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoAnimal;
import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class CadastroAnimal implements InterfaceCadastroAnimal {

    @Autowired
    private InterfaceColecaoAnimal colecaoAnimal;
    @Autowired 
    private CadastroUsuario cadastroUsuario;

    public List <Animal> listarAnimais(){
        return colecaoAnimal.findAll();
    }

    public Animal salvarAnimal(Animal entity) throws UsuarioNaoEncontradoException{
        Usuario usuario = cadastroUsuario.encontraUsuario(entity.getDonoId());
        if(usuario == null)
            throw new UsuarioNaoEncontradoException(entity.getDonoId());
        return colecaoAnimal.save(entity);
    }

    public List<Animal> listarAnimaisPeloDono(Long donoId) throws UsuarioNaoEncontradoException {
        Usuario usuario = cadastroUsuario.encontraUsuario(donoId);
        if (usuario == null)
            throw new UsuarioNaoEncontradoException(donoId);
        return colecaoAnimal.findByDonoId(donoId);
    }
}

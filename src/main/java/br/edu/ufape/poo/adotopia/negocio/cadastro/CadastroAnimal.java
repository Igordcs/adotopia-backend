package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoAnimal;
import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;

@Service
public class CadastroAnimal implements InterfaceCadastroAnimal {

    @Autowired
    private InterfaceColecaoAnimal colecaoAnimal;
    @Autowired 
    private CadastroUsuario cadastroUsuario;

    public List <Animal> listarAnimais(){
        return colecaoAnimal.findAll();
    }

    public Animal salvarAnimal(Animal entity){
        Usuario usuario = cadastroUsuario.adicionarAnimal(entity);
        if (usuario == null)
            return null;

        return colecaoAnimal.save(entity);
    }
}

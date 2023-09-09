package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

public interface InterfaceCadastroAnimal {

    public List <Animal> listarAnimais();

    public Animal salvarAnimal(Animal entity, Long id) throws UsuarioNaoEncontradoException;
    
    public List<Animal> listarAnimaisPeloDono(Long id) throws UsuarioNaoEncontradoException;
}

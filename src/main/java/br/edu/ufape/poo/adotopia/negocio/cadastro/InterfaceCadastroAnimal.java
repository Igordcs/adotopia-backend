package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

public interface InterfaceCadastroAnimal {

    public List <Animal> listarAnimais();

    public Animal salvarAnimal(Animal entity) throws UsuarioNaoEncontradoException;
    
    public List<Animal> listarAnimaisPeloDono(Long id) throws UsuarioNaoEncontradoException;
}

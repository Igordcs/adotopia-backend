package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;

public interface InterfaceCadastroAnimal {

    public List <Animal> listarAnimais();

    public Animal salvarAnimal(Animal entity);
    
}

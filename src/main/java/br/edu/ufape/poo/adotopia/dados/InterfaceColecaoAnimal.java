package br.edu.ufape.poo.adotopia.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;

@Repository
public interface InterfaceColecaoAnimal extends JpaRepository <Animal, Long> {

    
    
}

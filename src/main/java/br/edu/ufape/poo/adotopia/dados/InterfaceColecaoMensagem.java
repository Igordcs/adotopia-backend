package br.edu.ufape.poo.adotopia.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;

@Repository
public interface InterfaceColecaoMensagem extends JpaRepository <Mensagem, Long>{
    public List<Mensagem> findById(long id);
    
}

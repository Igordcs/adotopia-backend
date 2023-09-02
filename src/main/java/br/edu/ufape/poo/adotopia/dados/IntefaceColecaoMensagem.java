package br.edu.ufape.poo.adotopia.dados;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;

@Repository
public interface IntefaceColecaoMensagem extends JpaRepository <Mensagem, Long>{
    
    public List<Mensagem> findAllByRemetenteId(Long id);
}

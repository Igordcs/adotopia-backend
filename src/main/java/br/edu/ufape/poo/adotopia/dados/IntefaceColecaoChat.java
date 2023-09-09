package br.edu.ufape.poo.adotopia.dados;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Chat;

@Repository
public interface IntefaceColecaoChat extends JpaRepository <Chat, Long>{
    
    public List<Chat> findAllByRemetenteIdOrDestinatarioId(Long remetenteId, Long destinatarioId);

}

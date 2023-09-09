package br.edu.ufape.poo.adotopia.dados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Chat;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;

@Repository
public interface IntefaceColecaoChat extends JpaRepository <Chat, Long>{
    
    public List<Chat> findAllByRemetenteIdOrDestinatarioId(Long remetenteId, Long destinatarioId);

    Optional<Chat> findByRemetenteAndDestinatario(Usuario remetente, Usuario destinatario);

    @Query("SELECT c FROM Chat c WHERE " +
           "(c.remetente = :remetente AND c.destinatario = :destinatario) " +
           "OR (c.remetente = :destinatario AND c.destinatario = :remetente)")
    Optional<Chat> findByRemetenteAndDestinatarioIgnoreOrder(
            @Param("remetente") Usuario remetente,
            @Param("destinatario") Usuario destinatario);

}

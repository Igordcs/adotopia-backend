package br.edu.ufape.poo.adotopia.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;

@Repository
public interface InterfaceColecaoUsuario extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByEmail(String Email);
};

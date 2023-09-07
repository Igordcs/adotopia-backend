package br.edu.ufape.poo.adotopia.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.adotopia.negocio.basica.Registro;

@Repository
public interface InterfaceColecaoRegistro extends JpaRepository<Registro, Long>{
    
    public List<Registro> findByAdotanteId(Long adotanteId);

}

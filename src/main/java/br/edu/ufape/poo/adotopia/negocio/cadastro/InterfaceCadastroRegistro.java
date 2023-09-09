package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

public interface InterfaceCadastroRegistro {

     public List<Registro> listarRegistros();
    
    public List<Registro> listarRegistrosporadotante(Long id) throws UsuarioNaoEncontradoException;
}

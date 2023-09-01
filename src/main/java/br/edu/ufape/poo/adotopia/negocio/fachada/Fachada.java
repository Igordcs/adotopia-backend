package br.edu.ufape.poo.adotopia.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class Fachada {
    @Autowired
    private CadastroUsuario cadastroUsuario;

    public List<Usuario> listarUsuarios() {
        return cadastroUsuario.listarUsuarios();
    }

    public Usuario salvarUsuario(Usuario entity) throws UsuarioJaCadastradoException {
        return cadastroUsuario.salvarUsuario(entity);
    }

    public Usuario encontraUsuario(Long id) {
        return cadastroUsuario.encontraUsuario(id);
    }

    public Usuario alterarUsuario(Usuario entity) throws UsuarioNaoEncontradoException{
        return cadastroUsuario.alterarUsuario(entity);
    }
}

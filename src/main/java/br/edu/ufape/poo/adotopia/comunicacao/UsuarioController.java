package br.edu.ufape.poo.adotopia.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.fachada.Fachada;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private Fachada fachada;

    @GetMapping()
    public List<Usuario> listarUsuarios() {
        return fachada.listarUsuarios();
    }
        
    @PostMapping()
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) throws UsuarioJaCadastradoException {
        return fachada.salvarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario encontraUsuario(@PathVariable Long id) {
        return fachada.encontraUsuario(id);
    }

    @PutMapping("")
    public Usuario alterarUsuario(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
        return fachada.alterarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public Usuario deletarUsuario(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        return fachada.deletarUsuario(id);
    }
}

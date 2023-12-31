package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

public interface InterfaceCadastroUsuario {
    public List<Usuario> listarUsuarios();

    public Usuario salvarUsuario(Usuario Entity) throws UsuarioJaCadastradoException;

    public Usuario procurarUsuarioEmail(String email) throws UsuarioNaoEncontradoException;

    public Usuario alterarUsuario(Usuario entity) throws UsuarioNaoEncontradoException;

    public Usuario encontraUsuario(Long id) throws UsuarioNaoEncontradoException;

    public Usuario deletarUsuario(Long id) throws UsuarioNaoEncontradoException;

    public Registro adotarAnimal (Long usuarioId, Long animalId);
}

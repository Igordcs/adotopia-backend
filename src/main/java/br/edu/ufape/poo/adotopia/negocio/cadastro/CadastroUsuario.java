package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoUsuario;
import br.edu.ufape.poo.adotopia.negocio.basica.Endereco;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class CadastroUsuario implements InterfaceCadastroUsuario {
    @Autowired
    private InterfaceColecaoUsuario colecaoUsuario;

    public List<Usuario> listarUsuarios() {
        return colecaoUsuario.findAll();
    }

    public Usuario procurarUsuarioEmail(String email) throws UsuarioNaoEncontradoException {
        Usuario usuario = colecaoUsuario.findByEmail(email).orElse(null);
        if(usuario == null) {
            throw new UsuarioNaoEncontradoException(email);
        }
        return usuario;
    } 

    public Usuario salvarUsuario(Usuario entity) throws UsuarioJaCadastradoException {
        try {
            procurarUsuarioEmail(entity.getEmail());
            throw new UsuarioJaCadastradoException(entity.getEmail());
        } catch (UsuarioNaoEncontradoException e) {
            return colecaoUsuario.save(entity);
        }
    } 

    public Usuario encontraUsuario(Long id) {
        return colecaoUsuario.findById(id).orElse(null);
    }


    public Usuario alterarUsuario(Usuario entity) throws UsuarioNaoEncontradoException {
        Usuario user = encontraUsuario(entity.getId());
        if (user == null)
            return null;

        user.setNome(entity.getNome());
        user.setEmail(entity.getEmail());
        user.setTelefone(entity.getTelefone());
        user.setDescricao(entity.getDescricao());        
        user.setMeusPets(entity.getMeusPets());

        if(entity.getEndereco() != null) {
            Endereco enderecoUsuario = user.getEndereco();
            enderecoUsuario.setLogradouro(entity.getEndereco().getLogradouro());
            enderecoUsuario.setCep(entity.getEndereco().getCep());
            enderecoUsuario.setNumero(entity.getEndereco().getNumero());
            enderecoUsuario.setUf(entity.getEndereco().getUf());
            enderecoUsuario.setBairro(entity.getEndereco().getBairro());
            enderecoUsuario.setComplemento(entity.getEndereco().getComplemento());
        }
        return colecaoUsuario.saveAndFlush(user);
    }

}

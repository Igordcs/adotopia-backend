package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoAnimal;
import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoRegistro;
import br.edu.ufape.poo.adotopia.dados.InterfaceColecaoUsuario;
import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Endereco;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Status;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class CadastroUsuario implements InterfaceCadastroUsuario {
    @Autowired
    private InterfaceColecaoUsuario colecaoUsuario;
    @Autowired
    private InterfaceColecaoAnimal colecaoAnimal;
    @Autowired
    private InterfaceColecaoRegistro colecaoRegistro;

    public List<Usuario> listarUsuarios() {
        return colecaoUsuario.findAll();
    }

    public Usuario procurarUsuarioEmail(String email) throws UsuarioNaoEncontradoException {
        Usuario usuario = colecaoUsuario.findByEmail(email).orElse(null);
        if(usuario == null) {
            throw new UsuarioNaoEncontradoException(null);
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

    public Usuario encontraUsuario(Long id) throws UsuarioNaoEncontradoException {
        return colecaoUsuario.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }


    public Usuario alterarUsuario(Usuario entity) throws UsuarioNaoEncontradoException {
        Usuario usuario;
        try {
            usuario = encontraUsuario(entity.getId());
        } catch(UsuarioNaoEncontradoException e) {
            throw new UsuarioNaoEncontradoException(entity.getId());
        }

        usuario.setNome(entity.getNome());
        usuario.setEmail(entity.getEmail());
        usuario.setTelefone(entity.getTelefone());
        usuario.setDescricao(entity.getDescricao());        

        if(entity.getEndereco() != null) {
            Endereco enderecoUsuario = usuario.getEndereco();
            enderecoUsuario.setLogradouro(entity.getEndereco().getLogradouro());
            enderecoUsuario.setCep(entity.getEndereco().getCep());
            enderecoUsuario.setNumero(entity.getEndereco().getNumero());
            enderecoUsuario.setUf(entity.getEndereco().getUf());
            enderecoUsuario.setBairro(entity.getEndereco().getBairro());
            enderecoUsuario.setComplemento(entity.getEndereco().getComplemento());
        }
        return colecaoUsuario.saveAndFlush(usuario);
    }

    public Usuario deletarUsuario(Long id) throws UsuarioNaoEncontradoException {
        Usuario usuario;
        try {
            usuario = encontraUsuario(id);
        } catch(UsuarioNaoEncontradoException e) {
            throw new UsuarioNaoEncontradoException(id);
        }
        colecaoUsuario.deleteById(id);
        return usuario;
    }

    public Registro adotarAnimal(Long usuarioId, Long animalId){
        Animal animal = colecaoAnimal.findById(animalId).orElseThrow(() -> new NoSuchElementException("Animal não encontrado"));
        Usuario usuario = colecaoUsuario.findById(usuarioId).orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));;
        if (animal.getStatus() == Status.DISPONIVEL){
            Registro registro = new Registro(usuario, animal.getDono(), new Date(),"AOIHSDFUOIAHFOIAHFKLZHKJBH", animal);
            animal.setStatus(Status.ADOTADO);
            animal.setDono(usuario);
            colecaoAnimal.save(animal);
            colecaoRegistro.save(registro);
            return registro;
        }
        else {
            throw new IllegalStateException("O animal não está disponível para adoção");
        }
    }

}

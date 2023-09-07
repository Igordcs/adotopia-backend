package br.edu.ufape.poo.adotopia.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroAnimal;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroMensagem;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroRegistro;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class Fachada {
    @Autowired
    private CadastroUsuario cadastroUsuario;
    @Autowired
    private CadastroAnimal cadastroAnimal;
    @Autowired
    private CadastroMensagem cadastroMensagem;
    @Autowired
    private CadastroRegistro cadastroRegistro;

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

    public Usuario deletarUsuario(Long id) throws UsuarioNaoEncontradoException{
        return cadastroUsuario.deletarUsuario(id);
    }

    public List<Animal> listarAnimais(){
        return cadastroAnimal.listarAnimais();
    }

    public Animal salvarAnimal(Animal entity) throws UsuarioNaoEncontradoException{
        return cadastroAnimal.salvarAnimal(entity);
    }

    public List<Animal> listarAnimaisPorDono(Long donoId) throws UsuarioNaoEncontradoException {
        return cadastroAnimal.listarAnimaisPeloDono(donoId);
    }

    public List<Mensagem> listarTodasMensagens(){
        return cadastroMensagem.listarTodasMensagens();
    }

    public List<Mensagem> listarMensagensRemetente(Long id){
        return cadastroMensagem.listarMensagensRemetente(id);
    }

    public Mensagem enviarMensagem(Mensagem entity){
        return cadastroMensagem.enviarMensagem(entity);
      }

    public Mensagem deletarMensagem(Long id){
        return cadastroMensagem.deletarMensagem(id);
    }

    public List<Registro> listarRegistros(){
        return cadastroRegistro.listarRegistros();
    }

    public Registro salvarRegistro(Registro entity) throws UsuarioNaoEncontradoException{
        return cadastroRegistro.salvarRegistro(entity);
    }

    public List<Registro> listarRegistrosporadotante(Long AdotanteId) throws UsuarioNaoEncontradoException{
        return cadastroRegistro.listarRegistrosporadotante(AdotanteId);
    }
}

package br.edu.ufape.poo.adotopia.negocio.fachada;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.adotopia.negocio.basica.Animal;
import br.edu.ufape.poo.adotopia.negocio.basica.Chat;
import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;
import br.edu.ufape.poo.adotopia.negocio.basica.Registro;
import br.edu.ufape.poo.adotopia.negocio.basica.Usuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroAnimal;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroChat;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroMensagem;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroRegistro;
import br.edu.ufape.poo.adotopia.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.AnimalNaoEncontradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.ChatJaCriadoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioJaCadastradoException;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.UsuarioNaoEncontradoException;

@Service
public class Fachada {
    @Autowired
    private CadastroUsuario cadastroUsuario;
    @Autowired
    private CadastroAnimal cadastroAnimal;
    @Autowired
    private CadastroChat cadastroChat;
    @Autowired
    private CadastroRegistro cadastroRegistro;
    @Autowired
    private CadastroMensagem cadastroMensagem;

    public List<Usuario> listarUsuarios() {
        return cadastroUsuario.listarUsuarios();
    }

    public Usuario salvarUsuario(Usuario entity) throws UsuarioJaCadastradoException {
        return cadastroUsuario.salvarUsuario(entity);
    }

    public Usuario encontraUsuario(Long id) throws UsuarioNaoEncontradoException{
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

    public Animal salvarAnimal(Animal entity, Long id) throws UsuarioNaoEncontradoException{
        return cadastroAnimal.salvarAnimal(entity, id);
    }

    public List<Animal> listarAnimaisPorDono(Long donoId) throws UsuarioNaoEncontradoException {
        return cadastroAnimal.listarAnimaisPeloDono(donoId);
    }

    public List<Chat> listarTodosChats(){
        return cadastroChat.listarTodosChats();
    }

    public List<Chat> listarChatsId(Long id){
        return cadastroChat.listarChatsId(id);
    }

    public Mensagem enviarMensagem(Mensagem mensagem, Long chatId, Long remetenteId){
        return cadastroMensagem.enviarMensagem(mensagem, chatId, remetenteId);
    }

    public List<Registro> listarRegistros(){
        return cadastroRegistro.listarRegistros();
    }

    public List<Registro> listarRegistrosporadotante(Long AdotanteId) throws UsuarioNaoEncontradoException{
        return cadastroRegistro.listarRegistrosporadotante(AdotanteId);
    }

    public Registro adotarAnimal (Long usuarioId, Long animalId){
        return cadastroUsuario.adotarAnimal(usuarioId, animalId);
    }

    public Chat criarChat (Long remetenteId, Long destinatarioId) throws NoSuchElementException, ChatJaCriadoException{
        return cadastroChat.criarChat(remetenteId, destinatarioId);
    }

    public Animal alterarAnimal(Animal entity, Long id) throws AnimalNaoEncontradoException, UsuarioNaoEncontradoException{
        return cadastroAnimal.alterarAnimal(entity, id);
    }

    public Animal encontraAnimal(Long id) throws AnimalNaoEncontradoException{
        return cadastroAnimal.encontraAnimal(id);
    }

    public Animal deletarAnimal(Long id) throws AnimalNaoEncontradoException{
        return cadastroAnimal.deletarAnimal(id);
    }
}

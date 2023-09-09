package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;
import java.util.NoSuchElementException;

import br.edu.ufape.poo.adotopia.negocio.basica.Chat;
import br.edu.ufape.poo.adotopia.negocio.cadastro.exception.ChatJaCriadoException;

public interface InterfaceCadastroChat {

	public List<Chat> listarTodosChats();

	public List<Chat> listarChatsId(Long id);

	//public Chat criarChat(Long remetenteId, Long destinatarioId);

	public Chat criarChat(Long remetenteId, Long destinatarioId) throws NoSuchElementException, ChatJaCriadoException;
}

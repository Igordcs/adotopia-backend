package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Chat;

public interface InterfaceCadastroChat {

	public List<Chat> listarTodosChats();

	public List<Chat> listarChatsId(Long id);

	public Chat criarChat(Long remetenteId, Long destinatarioId);
}

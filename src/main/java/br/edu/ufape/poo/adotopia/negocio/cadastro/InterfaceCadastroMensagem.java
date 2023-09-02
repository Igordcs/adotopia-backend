package br.edu.ufape.poo.adotopia.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;

public interface InterfaceCadastroMensagem {

	public List<Mensagem> listarTodasMensagens();

	public List<Mensagem> listarMensagensRemetente(Long id);

	public Mensagem enviarMensagem (Mensagem entity);

	public Mensagem deletarMensagem (Long id)
;}

package br.edu.ufape.poo.adotopia.negocio.cadastro;

import br.edu.ufape.poo.adotopia.negocio.basica.Mensagem;

public interface InterfaceCadastroMensagem {

    public Mensagem enviarMensagem (Mensagem mensagem, Long chatId, Long remetenteId);

}

package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class ChatJaCriadoException extends Exception {
    private static final Long serialVersionUID = 1L;

    public ChatJaCriadoException() {
        super("Um chat entre estes usuários já foi criado!");
    }
}

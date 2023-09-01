package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class UsuarioNaoEncontradoException extends Exception {
    private static final Long serialVersionUID = 1L;
    private final String email;

    public UsuarioNaoEncontradoException(String email) {
        super("Nenhum usuário cadastrado foi encontrado com esse email!");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

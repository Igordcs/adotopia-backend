package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class UsuarioNaoEncontradoException extends Exception {
    private static final Long serialVersionUID = 1L;
    private final Long id;

    public UsuarioNaoEncontradoException(Long id) {
        super("Nenhum usuário cadastrado foi encontrado!");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}

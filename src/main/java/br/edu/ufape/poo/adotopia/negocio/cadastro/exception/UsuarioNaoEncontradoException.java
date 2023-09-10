package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class UsuarioNaoEncontradoException extends ObjetoNaoEncontrado {
    private static final Long serialVersionUID = 1L;
    private final Long id;    
    private final String email;

     public UsuarioNaoEncontradoException(String email) {
        super("Usuario");
        this.id = null;
        this.email = email;
    }

    public UsuarioNaoEncontradoException(Long id) {
        super("Usuario");
        this.id = id;
        this.email = null;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

}

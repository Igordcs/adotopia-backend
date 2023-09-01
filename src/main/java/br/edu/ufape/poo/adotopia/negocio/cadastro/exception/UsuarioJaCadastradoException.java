package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class UsuarioJaCadastradoException extends Exception {
    private static final Long serialVersionUID = 1L;
    private final String email;
    
    public UsuarioJaCadastradoException(String email) {
        super("O usuário já está cadastrado!");

        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}

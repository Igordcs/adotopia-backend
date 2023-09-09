package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class AnimalNaoEncontradoException extends Exception {
    
    private static final Long serialVersionUID = 1L;
    private final Long id;

    public AnimalNaoEncontradoException (Long id) {
        super("Nenhum animal cadastrado foi encontrado!");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }


}

package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class AnimalNaoEncontradoException extends ObjetoNaoEncontrado {
    private static final Long serialVersionUID = 1L;
    private final Long id;

    public AnimalNaoEncontradoException (Long id) {
        super("Animal");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }


}

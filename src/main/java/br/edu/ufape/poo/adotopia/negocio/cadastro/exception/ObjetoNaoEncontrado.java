package br.edu.ufape.poo.adotopia.negocio.cadastro.exception;

public class ObjetoNaoEncontrado extends Exception {
    private static final Long serialVersionUID = 1L;

    public ObjetoNaoEncontrado(String classe) {
        super(String.format("%s nao foi encontrado", classe));
    }
}

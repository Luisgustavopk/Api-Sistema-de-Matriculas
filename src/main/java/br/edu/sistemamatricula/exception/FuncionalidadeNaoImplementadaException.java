package br.edu.sistemamatricula.exception;

/** Distingue os stubs planejados de falhas inesperadas de programação. */
public class FuncionalidadeNaoImplementadaException extends RuntimeException {
    public FuncionalidadeNaoImplementadaException(String funcionalidade) {
        super(funcionalidade + ": implementação prevista para a sprint 3.");
    }
}

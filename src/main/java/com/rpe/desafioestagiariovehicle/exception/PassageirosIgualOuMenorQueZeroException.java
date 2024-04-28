package com.rpe.desafioestagiariovehicle.exception;

public class PassageirosIgualOuMenorQueZeroException extends RuntimeException{
    public PassageirosIgualOuMenorQueZeroException() {
        super("Veículos de passeio não podem ter capacidade de passageiros menor ou igual a zero.");
    }
}

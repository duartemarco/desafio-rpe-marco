package com.rpe.desafioestagiariovehicle.exception;

public class CargaOuCarroceriaNegativaException extends RuntimeException{
    public CargaOuCarroceriaNegativaException() {
        super("Veículos de carga não podem ter capacidade ou carrocerias negativas.");
    }
}

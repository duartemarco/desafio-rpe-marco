package com.rpe.desafioestagiariovehicle.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class VeiculoPasseio extends Veiculo {

    private int numeroDePassageiros;

//    Veículo de Passeio: Veículo utilizado para alguns funcionários visitarem seus clientes.
//    Atributos: Placa, Nome, Marca, Número de Passageiros
}

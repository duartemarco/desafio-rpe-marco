package com.rpe.desafioestagiariovehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table (name = "tbl_veiculo_passeio")
public class VeiculoPasseio extends Veiculo {

    @Column
    private int numeroDePassageiros;

//    Veículo de Passeio: Veículo utilizado para alguns funcionários visitarem seus clientes.
//    Atributos: Placa, Nome, Marca, Número de Passageiros
}

package com.rpe.desafioestagiariovehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "tbl_veiculo_passeio")
public class VeiculoPasseio extends Veiculo {

    //    Veículo de Passeio: Veículo utilizado para alguns funcionários visitarem seus clientes.
    //    Atributos: Placa, Nome, Marca, Número de Passageiros

    @Column(nullable = false)
    private int numeroDePassageiros;

    public int getNumeroDePassageiros() {
        return numeroDePassageiros;
    }

    public void setNumeroDePassageiros(int numeroDePassageiros) {
        this.numeroDePassageiros = numeroDePassageiros;
    }


}

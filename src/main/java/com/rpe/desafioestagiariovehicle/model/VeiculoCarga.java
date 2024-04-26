package com.rpe.desafioestagiariovehicle.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class VeiculoCarga extends Veiculo {

    private long capacidadeEmKg;
    private int quantidadeDeCarroceria;

//    Veículo de Carga: Veículo utilizado para fazer entregas de mercadorias.
//    Atributos: Placa, Nome, Marca, Capacidade, Quantidade de Carroceria
}

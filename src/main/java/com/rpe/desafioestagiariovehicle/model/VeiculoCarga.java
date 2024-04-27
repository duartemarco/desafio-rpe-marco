package com.rpe.desafioestagiariovehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "tbl_veiculo_carga")
public class VeiculoCarga extends Veiculo {

    //    Veículo de Carga: Veículo utilizado para fazer entregas de mercadorias.
    //    Atributos: Placa, Nome, Marca, Capacidade, Quantidade de Carroceria

    @Column
    private Long capacidadeEmKg;

    @Column
    private int quantidadeDeCarroceria;

    public Long getCapacidadeEmKg() {
        return capacidadeEmKg;
    }

    public void setCapacidadeEmKg(Long capacidadeEmKg) {
        this.capacidadeEmKg = capacidadeEmKg;
    }

    public int getQuantidadeDeCarroceria() {
        return quantidadeDeCarroceria;
    }

    public void setQuantidadeDeCarroceria(int quantidadeDeCarroceria) {
        this.quantidadeDeCarroceria = quantidadeDeCarroceria;
    }


}

package com.rpe.desafioestagiariovehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Table (name = "tbl_veiculo_carga")
public class VeiculoCarga extends Veiculo {

    @Column
    private Long capacidadeEmKg;

    @Column
    private int quantidadeDeCarroceria;





//    Veículo de Carga: Veículo utilizado para fazer entregas de mercadorias.
//    Atributos: Placa, Nome, Marca, Capacidade, Quantidade de Carroceria
}

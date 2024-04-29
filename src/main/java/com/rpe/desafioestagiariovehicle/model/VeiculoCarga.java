package com.rpe.desafioestagiariovehicle.model;

import com.rpe.desafioestagiariovehicle.dto.VeiculoCargaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_veiculo_carga")
public class VeiculoCarga extends Veiculo {

    @Column(nullable = false)
    private Long capacidadeEmKg;

    @Column(nullable = false)
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

    public static VeiculoCarga convert(VeiculoCargaDTO veiculoCargaDTO) {
        VeiculoCarga veiculoCarga = new VeiculoCarga();
        veiculoCarga.setPlaca(veiculoCargaDTO.getPlaca());
        veiculoCarga.setMarca(veiculoCargaDTO.getMarca());
        veiculoCarga.setNome(veiculoCargaDTO.getNome());
        veiculoCarga.setId(veiculoCargaDTO.getId());
        veiculoCarga.setCapacidadeEmKg(veiculoCargaDTO.getCapacidadeEmKg());
        veiculoCarga.setQuantidadeDeCarroceria(veiculoCargaDTO.getQuantidadeDeCarroceria());
        return veiculoCarga;
    }

}

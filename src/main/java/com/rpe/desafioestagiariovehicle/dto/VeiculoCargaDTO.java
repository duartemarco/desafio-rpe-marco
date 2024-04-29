package com.rpe.desafioestagiariovehicle.dto;

import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoCargaDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    @NotNull
    private Long capacidadeEmKg;

    @NotNull
    private int quantidadeDeCarroceria;

    public static VeiculoCargaDTO convert(VeiculoCarga veiculoCarga) {
        VeiculoCargaDTO veiculoCargaDTO = new VeiculoCargaDTO();
        veiculoCargaDTO.setId(veiculoCarga.getId());
        veiculoCargaDTO.setPlaca(veiculoCarga.getPlaca());
        veiculoCargaDTO.setMarca(veiculoCarga.getMarca());
        veiculoCargaDTO.setNome(veiculoCarga.getNome());
        veiculoCargaDTO.setCapacidadeEmKg(veiculoCarga.getCapacidadeEmKg());
        veiculoCargaDTO.setQuantidadeDeCarroceria(veiculoCarga.getQuantidadeDeCarroceria());
        return veiculoCargaDTO;
    }

}

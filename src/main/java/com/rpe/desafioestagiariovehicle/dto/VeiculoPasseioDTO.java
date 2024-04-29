package com.rpe.desafioestagiariovehicle.dto;

import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
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
public class VeiculoPasseioDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    @NotNull
    private int numeroDePassageiros;

    public static VeiculoPasseioDTO convert(VeiculoPasseio veiculoPasseio) {
        VeiculoPasseioDTO veiculoPasseioDTO = new VeiculoPasseioDTO();
        veiculoPasseioDTO.setId(veiculoPasseio.getId());
        veiculoPasseioDTO.setNome(veiculoPasseio.getNome());
        veiculoPasseioDTO.setPlaca(veiculoPasseio.getPlaca());
        veiculoPasseioDTO.setMarca(veiculoPasseio.getMarca());
        veiculoPasseioDTO.setNumeroDePassageiros(veiculoPasseio.getNumeroDePassageiros());
        return veiculoPasseioDTO;
    }
}

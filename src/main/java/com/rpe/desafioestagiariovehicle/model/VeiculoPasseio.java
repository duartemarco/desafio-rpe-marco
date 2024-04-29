package com.rpe.desafioestagiariovehicle.model;

import com.rpe.desafioestagiariovehicle.dto.VeiculoPasseioDTO;
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

    public static VeiculoPasseio convert(VeiculoPasseioDTO veiculoPasseioDTO) {
        VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
        veiculoPasseio.setPlaca(veiculoPasseioDTO.getPlaca());
        veiculoPasseio.setMarca(veiculoPasseioDTO.getMarca());
        veiculoPasseio.setNome(veiculoPasseioDTO.getNome());
        veiculoPasseio.setId(veiculoPasseioDTO.getId());
        veiculoPasseio.setNumeroDePassageiros(veiculoPasseioDTO.getNumeroDePassageiros());
        return veiculoPasseio;
    }

}

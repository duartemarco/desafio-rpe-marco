package com.rpe.desafioestagiariovehicle.repository;

import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoPasseioRepository extends JpaRepository<VeiculoPasseio, Long> {
    VeiculoPasseio findVeiculoPasseioByPlaca(String placa);
}

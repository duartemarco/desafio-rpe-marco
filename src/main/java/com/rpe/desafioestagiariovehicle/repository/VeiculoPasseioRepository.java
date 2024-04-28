package com.rpe.desafioestagiariovehicle.repository;

import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoPasseioRepository extends JpaRepository<VeiculoPasseio, Long> {
    VeiculoPasseio findVeiculoPasseioByPlaca(String placa);
}

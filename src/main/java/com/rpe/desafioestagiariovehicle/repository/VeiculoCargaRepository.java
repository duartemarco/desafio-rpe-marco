package com.rpe.desafioestagiariovehicle.repository;

import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoCargaRepository extends JpaRepository<VeiculoCarga, Long> {
    VeiculoCarga findVeiculoCargaByPlaca(String placa);
}

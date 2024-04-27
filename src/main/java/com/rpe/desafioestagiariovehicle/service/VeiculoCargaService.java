package com.rpe.desafioestagiariovehicle.service;

import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import com.rpe.desafioestagiariovehicle.repository.VeiculoCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoCargaService {

    @Autowired
    private VeiculoCargaRepository repository;

    //* Endpoint para adicionar um Veículo de Carga
    public VeiculoCarga cadastraVeiculoCarga(VeiculoCarga veiculoCarga) {
        return repository.save(veiculoCarga);
    }

    //* Endpoint para consultar um Veículo de Carga
    public VeiculoCarga getVeiculoCargaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    //* Endpoint para alterar um Veículo de Carga
    public VeiculoCarga atualizarVeiculoCarga(Long id, VeiculoCarga veiculoCargaAtualizado) {
        return repository.findById(id).map(veiculoCarga -> {
            veiculoCarga.setCapacidadeEmKg(veiculoCargaAtualizado.getCapacidadeEmKg());
            veiculoCarga.setQuantidadeDeCarroceria(veiculoCarga.getQuantidadeDeCarroceria());
            veiculoCarga.setPlaca(veiculoCargaAtualizado.getPlaca());
            veiculoCarga.setNome(veiculoCargaAtualizado.getNome());
            veiculoCarga.setMarca(veiculoCargaAtualizado.getMarca());
            return repository.save(veiculoCarga);
        }).orElse(null);
    }

    //* Endpoint para remover um Veículo de Carga
    public void deleteVeiculoCarga(Long id) {
        repository.deleteById(id);
    }

    public VeiculoCarga getVeiculoCargaByPlaca(String placa) {
        return repository.findVeiculoCargaByPlaca(placa);
    }
}

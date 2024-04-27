package com.rpe.desafioestagiariovehicle.service;

import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import com.rpe.desafioestagiariovehicle.repository.VeiculoPasseioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoPasseioService {

    @Autowired
    private VeiculoPasseioRepository repository;

    //* Endpoint para adicionar um Veículo de Passeio
    public VeiculoPasseio cadastraVeiculoPasseio(VeiculoPasseio veiculoPasseio) {
        return repository.save(veiculoPasseio);
    }

    //* Endpoint para consultar um Veículo de Passeio
    public VeiculoPasseio getVeiculoPasseioById(Long id) {
        return repository.findById(id).orElse(null);
    }

    //* Endpoint para alterar um Veículo de Passeio
    public VeiculoPasseio atualizarVeiculoPasseio(Long id, VeiculoPasseio veiculoPasseioAtualizado) {
        return repository.findById(id).map(veiculoPasseio -> {
            veiculoPasseio.setNumeroDePassageiros(veiculoPasseioAtualizado.getNumeroDePassageiros());
            veiculoPasseio.setPlaca(veiculoPasseioAtualizado.getPlaca());
            veiculoPasseio.setNome(veiculoPasseioAtualizado.getNome());
            veiculoPasseio.setMarca(veiculoPasseioAtualizado.getMarca());
            return repository.save(veiculoPasseio);
        }).orElse(null);
    }

    //* Endpoint para remover um Veículo de Passeio
    public void deleteVeiculoPasseio(Long id) {
        repository.deleteById(id);
    }

}

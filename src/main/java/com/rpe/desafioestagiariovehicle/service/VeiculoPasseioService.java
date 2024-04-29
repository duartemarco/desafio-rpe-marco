package com.rpe.desafioestagiariovehicle.service;

import com.rpe.desafioestagiariovehicle.dto.VeiculoPasseioDTO;
import com.rpe.desafioestagiariovehicle.exception.PassageirosIgualOuMenorQueZeroException;
import com.rpe.desafioestagiariovehicle.exception.PlacaExistenteException;
import com.rpe.desafioestagiariovehicle.exception.VeiculoNotFoundException;
import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import com.rpe.desafioestagiariovehicle.repository.VeiculoPasseioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoPasseioService {

    @Autowired
    private VeiculoPasseioRepository repository;

    //* Serviço para adicionar um Veículo de Passeio
    public VeiculoPasseioDTO cadastraVeiculoPasseio(VeiculoPasseioDTO veiculoPasseioDTO) {

        VeiculoPasseio veiculoPasseioExistente = getVeiculoPasseioByPlaca(veiculoPasseioDTO.getPlaca());
        if (veiculoPasseioExistente != null) {
            throw new PlacaExistenteException();
        }

        if (veiculoPasseioDTO.getNumeroDePassageiros() <= 0) {
            throw new PassageirosIgualOuMenorQueZeroException();
        }

        VeiculoPasseio veiculoPasseio = repository.save(VeiculoPasseio.convert(veiculoPasseioDTO));
        return VeiculoPasseioDTO.convert(veiculoPasseio);
    }

    //* Serviço para consultar um Veículo de Passeio
    public VeiculoPasseioDTO getVeiculoPasseioById(Long id) {
        VeiculoPasseio veiculoPasseio = repository.findById(id).orElseThrow(VeiculoNotFoundException::new);
        if (veiculoPasseio != null) {
            return VeiculoPasseioDTO.convert(veiculoPasseio);
        }
        throw new VeiculoNotFoundException();
    }



    //* Serviço para alterar um Veículo de Passeio
    public VeiculoPasseio atualizarVeiculoPasseio(Long id, VeiculoPasseio veiculoPasseioAtualizado) {
        return repository.findById(id).map(veiculoPasseio -> {
            veiculoPasseio.setNumeroDePassageiros(veiculoPasseioAtualizado.getNumeroDePassageiros());
            veiculoPasseio.setPlaca(veiculoPasseioAtualizado.getPlaca());
            veiculoPasseio.setNome(veiculoPasseioAtualizado.getNome());
            veiculoPasseio.setMarca(veiculoPasseioAtualizado.getMarca());
            return repository.save(veiculoPasseio);
        }).orElse(null);
    }

    //* Serviço para remover um Veículo de Passeio
    public void deleteVeiculoPasseio(Long id) {
        repository.deleteById(id);
    }

    public VeiculoPasseio getVeiculoPasseioByPlaca(String placa) {
        return repository.findVeiculoPasseioByPlaca(placa);
    }
}

package com.rpe.desafioestagiariovehicle.service;

import com.rpe.desafioestagiariovehicle.dto.VeiculoCargaDTO;
import com.rpe.desafioestagiariovehicle.exception.CargaOuCarroceriaNegativaException;
import com.rpe.desafioestagiariovehicle.exception.VeiculoNotFoundException;
import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import com.rpe.desafioestagiariovehicle.repository.VeiculoCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoCargaService {

    @Autowired
    private VeiculoCargaRepository repository;

    //* Serviço para adicionar um Veículo de Carga
    public VeiculoCarga cadastraVeiculoCarga(VeiculoCarga veiculoCarga) {

        VeiculoCarga veiculoCargaExistente = getVeiculoCargaByPlaca(veiculoCarga.getPlaca());
        if (veiculoCargaExistente != null) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com a mesma placa.");
        }

        if (veiculoCarga.getQuantidadeDeCarroceria() < 0 || veiculoCarga.getCapacidadeEmKg() < 0) {
            throw new CargaOuCarroceriaNegativaException();
        }


        return repository.save(veiculoCarga);
    }

    //* Serviço para consultar um Veículo de Carga
    public VeiculoCargaDTO getVeiculoCargaById(Long id) {
        VeiculoCarga veiculoCarga = repository.findById(id).orElseThrow(VeiculoNotFoundException::new);
        if (veiculoCarga != null) {
            return VeiculoCargaDTO.convert(veiculoCarga);
        }
        throw new VeiculoNotFoundException();
    }

    /*
         public VeiculoCargaDTO save(VeiculoCargaDTO veiculoCargaDTO) {
         VeiculoCarga veiculoCarga =
         repository.save(VeiculoCarga.convert(veiculoCargaDTO));
         return VeiculoCargaDTO.convert(veiculoCarga);
         }
     */


    //* Serviço para alterar um Veículo de Carga
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

    //* Serviço para remover um Veículo de Carga
    public void deleteVeiculoCarga(Long id) {
        repository.deleteById(id);
    }

    public VeiculoCarga getVeiculoCargaByPlaca(String placa) {
        return repository.findVeiculoCargaByPlaca(placa);
    }
}

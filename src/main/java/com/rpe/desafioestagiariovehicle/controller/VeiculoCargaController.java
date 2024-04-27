package com.rpe.desafioestagiariovehicle.controller;

import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import com.rpe.desafioestagiariovehicle.service.VeiculoCargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos/carga")
public class VeiculoCargaController {

    private final VeiculoCargaService veiculoCargaService;

    @Autowired
    public VeiculoCargaController(VeiculoCargaService veiculoCargaService) {
        this.veiculoCargaService = veiculoCargaService;
    }

    //* Endpoint para adicionar um Veículo de Carga
//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public VeiculoCarga addVeiculoCarga(@RequestBody VeiculoCarga veiculoCarga){
//        return veiculoCargaService.cadastraVeiculoCarga(veiculoCarga);
//    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoCarga addVeiculoCarga(@RequestBody VeiculoCarga veiculoCarga) {
        // Verificar se já existe um veículo de carga com a mesma placa (o ideal seria consultar se já existe um veículo
        // em quaisquer repositórios com a mesma placa. Implementar caso sobre tempo.
        VeiculoCarga veiculoCargaExistente = veiculoCargaService.getVeiculoCargaByPlaca(veiculoCarga.getPlaca());
        if (veiculoCargaExistente != null) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com a mesma placa.");
        }

        return veiculoCargaService.cadastraVeiculoCarga(veiculoCarga);
    }

    //* Endpoint para consultar um Veículo de Carga
    @GetMapping("/{id}")
    public VeiculoCarga getVeiculoCargaById (@PathVariable Long id) {
        return veiculoCargaService.getVeiculoCargaById(id);
    }

    //* Endpoint para alterar um Veículo de Carga
    @PutMapping("/update/{id}")
    public VeiculoCarga atualizarVeiculoCarga(@PathVariable Long id, @RequestBody VeiculoCarga veiculoCargaAtualizado) {
        return veiculoCargaService.atualizarVeiculoCarga(id, veiculoCargaAtualizado);
    }

    //* Endpoint para remover um Veículo de Carga
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVeiculoCarga(@PathVariable Long id) {
        veiculoCargaService.deleteVeiculoCarga(id);
    }
}

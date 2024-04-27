package com.rpe.desafioestagiariovehicle.controller;

import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import com.rpe.desafioestagiariovehicle.service.VeiculoCargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carga")
public class VeiculoCargaController {

    private final VeiculoCargaService veiculoCargaService;

    @Autowired
    public VeiculoCargaController(VeiculoCargaService veiculoCargaService) {
        this.veiculoCargaService = veiculoCargaService;
    }

    //* Endpoint para adicionar um Veículo de Carga
    @PostMapping("/add")
    public VeiculoCarga addVeiculoCarga(@RequestBody VeiculoCarga veiculoCarga){
        return veiculoCargaService.cadastraVeiculoCarga(veiculoCarga);
    }

    //* Endpoint para consultar um Veículo de Carga
    @GetMapping("/id/{id}")
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
    public void deleteVeiculoCarga(@PathVariable Long id) {
        veiculoCargaService.deleteVeiculoCarga(id);
    }
}

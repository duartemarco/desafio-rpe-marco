package com.rpe.desafioestagiariovehicle.controller;

import com.rpe.desafioestagiariovehicle.dto.VeiculoPasseioDTO;
import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import com.rpe.desafioestagiariovehicle.service.VeiculoPasseioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos/passeio")
public class VeiculoPasseioController {

    private final VeiculoPasseioService veiculoPasseioService;

    @Autowired
    public VeiculoPasseioController(VeiculoPasseioService veiculoPasseioService) {
        this.veiculoPasseioService = veiculoPasseioService;
    }

    //* Endpoint para adicionar um Veículo de Passeio
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoPasseio addVeiculoPasseio(@RequestBody VeiculoPasseio veiculoPasseio) {
        return veiculoPasseioService.cadastraVeiculoPasseio(veiculoPasseio);
    }

    //* Endpoint para consultar um Veículo de Passeio
    @GetMapping("/{id}")
    public VeiculoPasseioDTO getVeiculoPasseioById(@PathVariable Long id) {
        return veiculoPasseioService.getVeiculoPasseioById(id);
    }

    //* Endpoint para alterar um Veículo de Passeio
    @PutMapping("/update/{id}")
    public VeiculoPasseio atualizarVeiculoPasseio(@PathVariable Long id, @RequestBody VeiculoPasseio veiculoPasseioAtualizado) {
        return veiculoPasseioService.atualizarVeiculoPasseio(id, veiculoPasseioAtualizado);
    }

    //* Endpoint para remover um Veículo de Passeio
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVeiculoPasseio(@PathVariable Long id) {
        veiculoPasseioService.deleteVeiculoPasseio(id);
    }

}

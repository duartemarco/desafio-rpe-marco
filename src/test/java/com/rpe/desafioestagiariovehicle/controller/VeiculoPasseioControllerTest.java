package com.rpe.desafioestagiariovehicle.controller;

import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import com.rpe.desafioestagiariovehicle.service.VeiculoPasseioService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VeiculoPasseioControllerTest {

    @Mock
    private VeiculoPasseioService veiculoPasseioService;

    @InjectMocks
    private VeiculoPasseioController veiculoPasseioController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(veiculoPasseioController).build();
    }

    @Test
    void addVeiculoPasseio() throws Exception{
        VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
        veiculoPasseio.setId(1L);
        veiculoPasseio.setNome("Corolla");
        veiculoPasseio.setMarca("Toyota");
        veiculoPasseio.setNumeroDePassageiros(5);
        veiculoPasseio.setPlaca("ABCD1234");

        when(veiculoPasseioService.cadastraVeiculoPasseio(any(VeiculoPasseio.class))).thenReturn(veiculoPasseio);

        mockMvc.perform(post("/veiculos/passeio/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"nome\": \"Corolla\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Corolla"))
                .andExpect(jsonPath("$.marca").value("Toyota"))
                .andExpect(jsonPath("$.placa").value("ABCD1234"))
                .andExpect(jsonPath("$.numeroDePassageiros").value(5));
    }

    @Test
    void getVeiculoPasseioById() throws Exception {
        VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
        veiculoPasseio.setId(1L);
        veiculoPasseio.setNome("Corolla");

        when(veiculoPasseioService.getVeiculoPasseioById(1L)).thenReturn(veiculoPasseio);

        mockMvc.perform(get("/veiculos/passeio/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Corolla"));
    }

    @Test
    void atualizarVeiculoPasseio() {
    }

    @Test
    void deleteVeiculoPasseio() {
    }
}
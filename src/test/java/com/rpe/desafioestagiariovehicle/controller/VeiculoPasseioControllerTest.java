package com.rpe.desafioestagiariovehicle.controller;

import com.rpe.desafioestagiariovehicle.dto.VeiculoPasseioDTO;
import com.rpe.desafioestagiariovehicle.exception.ValoresInvalidosException;
import com.rpe.desafioestagiariovehicle.model.VeiculoPasseio;
import com.rpe.desafioestagiariovehicle.service.VeiculoPasseioService;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    void addVeiculoPasseioValido() throws Exception{
        VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
        veiculoPasseio.setId(1L);
        veiculoPasseio.setNome("Corolla");
        veiculoPasseio.setMarca("Toyota");
        veiculoPasseio.setNumeroDePassageiros(5);
        veiculoPasseio.setPlaca("ABCD1234");

        when(veiculoPasseioService.cadastraVeiculoPasseio(VeiculoPasseioDTO.convert(any(VeiculoPasseio.class)))).thenReturn(VeiculoPasseioDTO.convert(veiculoPasseio));

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
    void AddVeiculoPasseioInvalido() throws Exception {
        VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
        veiculoPasseio.setNumeroDePassageiros(0);

        assertThrows(ValoresInvalidosException.class, () -> {
            veiculoPasseioController.addVeiculoPasseio(VeiculoPasseioDTO.convert(veiculoPasseio));
        });
    }

    @Test
    void getVeiculoPasseioById() throws Exception {
        VeiculoPasseio veiculoPasseio = new VeiculoPasseio();
        veiculoPasseio.setId(1L);
        veiculoPasseio.setNome("Corolla");

        when(veiculoPasseioService.getVeiculoPasseioById(1L)).thenReturn(VeiculoPasseioDTO.convert(veiculoPasseio));

        mockMvc.perform(get("/veiculos/passeio/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Corolla"));
    }

    @Test
    void atualizarVeiculoPasseio() throws Exception{
        VeiculoPasseio veiculoPasseioAtualizado = new VeiculoPasseio();
        veiculoPasseioAtualizado.setId(1L);
        veiculoPasseioAtualizado.setNome("Fusca");

        when(veiculoPasseioService.atualizarVeiculoPasseio(1L, veiculoPasseioAtualizado)).thenReturn(veiculoPasseioAtualizado);

        mockMvc.perform(put("/veiculos/passeio/update/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"nome\": \"Fusca\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Fusca"));
    }

    @Test
    void deleteVeiculoPasseio() throws Exception {
        mockMvc.perform(delete("/veiculos/passeio/delete/{id}", 1))
                .andExpect(status().isNoContent());

        verify(veiculoPasseioService, times(1)).deleteVeiculoPasseio(1L);
    }
}
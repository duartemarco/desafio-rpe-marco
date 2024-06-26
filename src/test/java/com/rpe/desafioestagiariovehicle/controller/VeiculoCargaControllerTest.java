package com.rpe.desafioestagiariovehicle.controller;

import com.rpe.desafioestagiariovehicle.dto.VeiculoCargaDTO;
import com.rpe.desafioestagiariovehicle.model.VeiculoCarga;
import com.rpe.desafioestagiariovehicle.service.VeiculoCargaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VeiculoCargaControllerTest {

    @Mock
    private VeiculoCargaService veiculoCargaService;

    @InjectMocks
    private VeiculoCargaController veiculoCargaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(veiculoCargaController).build();
    }

    @Test
    void addVeiculoCargaValido() throws Exception {
        VeiculoCargaDTO veiculoCarga = new VeiculoCargaDTO();
        veiculoCarga.setId(1L);
        veiculoCarga.setNome("Caminhonete");
        veiculoCarga.setMarca("Volkswagen");
        veiculoCarga.setQuantidadeDeCarroceria(50);
        veiculoCarga.setCapacidadeEmKg(1500L);
        veiculoCarga.setPlaca("ABCD1234");

        when(veiculoCargaService.cadastraVeiculoCarga(any(VeiculoCargaDTO.class))).thenReturn(veiculoCarga);

        mockMvc.perform(post("/veiculos/carga/add/").contentType(MediaType.APPLICATION_JSON).content("{\"id\": 1, \"nome\": \"Caminhonete\", \"marca\": \"Volkswagen\", \"quantidadeDeCarroceria\": 50, \"capacidadeEmKg\": 1500, \"placa\": \"ABCD1234\"}")).andExpect(status().isCreated()).andExpect(jsonPath("$.nome").value("Caminhonete")).andExpect(jsonPath("$.id").value(1L)).andExpect(jsonPath("$.marca").value("Volkswagen")).andExpect(jsonPath("$.quantidadeDeCarroceria").value(50)).andExpect(jsonPath("$.capacidadeEmKg").value(1500L)).andExpect(jsonPath("$.placa").value("ABCD1234"));
    }

    @Test
    void getVeiculoCargaById() throws Exception {
        VeiculoCarga veiculoCarga = new VeiculoCarga();
        veiculoCarga.setId(1L);
        veiculoCarga.setNome("Caminhonete");

        when(veiculoCargaService.getVeiculoCargaById(1L)).thenReturn(VeiculoCargaDTO.convert(veiculoCarga));

        mockMvc.perform(get("/veiculos/carga/{id}", 1)).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.nome").value("Caminhonete"));
    }

    @Test
    void atualizarVeiculoCarga() throws Exception {
        VeiculoCarga veiculoCargaAtualizado = new VeiculoCarga();
        veiculoCargaAtualizado.setId(1L);
        veiculoCargaAtualizado.setNome("Bitrem");

        when(veiculoCargaService.atualizarVeiculoCarga(1L, veiculoCargaAtualizado)).thenReturn(veiculoCargaAtualizado);

        mockMvc.perform(put("/veiculos/carga/update/{id}", 1).contentType(MediaType.APPLICATION_JSON).content("{ \"nome\": \"Bitrem\" }")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.nome").value("Bitrem"));
    }

    @Test
    void deleteVeiculoCarga() throws Exception {
        mockMvc.perform(delete("/veiculos/carga/delete/{id}", 1)).andExpect(status().isNoContent());

        verify(veiculoCargaService, times(1)).deleteVeiculoCarga(1L);
    }
}

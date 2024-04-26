package com.rpe.desafioestagiariovehicle.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Veiculo {

    @Id
    private long id;
    private String placa;
    private String nome;
    private String marca;

    // Ao criar uma classe base, uma possível escalonação da aplicação se torna mais fácil e prática.

}

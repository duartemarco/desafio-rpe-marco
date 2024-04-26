package com.rpe.desafioestagiariovehicle.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
//@Entity
//@Getter
//@Setter
@MappedSuperclass
public class Veiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String placa;
    // Teste

    @Column
    private String nome;

    @Column
    private String marca;

    // Ao criar uma classe base, uma possível escalonação da aplicação se torna mais fácil e prática.

}

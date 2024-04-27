package com.rpe.desafioestagiariovehicle.model;


import jakarta.persistence.*;
import lombok.*;

//@Data
//@Entity
@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String placa;

    @Column
    private String nome;

    @Column
    private String marca;

    // Ao criar uma classe base, uma possível escalonação da aplicação se torna mais fácil e prática.

}

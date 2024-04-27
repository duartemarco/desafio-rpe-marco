package com.rpe.desafioestagiariovehicle.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@MappedSuperclass
public class Veiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String placa;

    @Column
    private String nome;

    @Column
    private String marca;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;

        if (!id.equals(veiculo.id)) return false;
        if (!placa.equals(veiculo.placa)) return false;
        if (!nome.equals(veiculo.nome)) return false;
        return marca.equals(veiculo.marca);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + placa.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + marca.hashCode();
        return result;
    }

    // Ao criar uma classe base, uma possível escalonação da aplicação se torna mais fácil e prática.

}

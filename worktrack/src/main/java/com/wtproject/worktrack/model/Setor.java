package com.wtproject.worktrack.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Setor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    public Setor(String nome) {
        this.nome = nome;
    }
}

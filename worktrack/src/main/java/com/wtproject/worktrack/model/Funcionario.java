package com.wtproject.worktrack.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Funcionario extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cargo;

    private String email;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    public Funcionario(String nome, String cargo, String email, Setor setor) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.setor = setor;
    }
}

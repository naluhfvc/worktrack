package com.wtproject.worktrack.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

package com.wtproject.worktrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Tarefa extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Tarefa(String titulo, String descricao, Funcionario funcionario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
        this.funcionario = funcionario;
    }
}

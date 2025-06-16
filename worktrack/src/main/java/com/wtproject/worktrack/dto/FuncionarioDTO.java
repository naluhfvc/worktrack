package com.wtproject.worktrack.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String cargo;
    private String email;
    private SetorDTO setor;
    private LocalDateTime dataCriacao;
}
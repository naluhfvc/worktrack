package com.wtproject.worktrack.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SetorDTO {
    private Long id;
    private String nome;
    private LocalDateTime dataCriacao;
}
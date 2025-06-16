package com.wtproject.worktrack.dto;

import lombok.Data;

@Data
public class FuncionarioCreateDTO {
    private String nome;
    private String cargo;
    private String email;
    private Long setorId;  // Só precisa do ID do setor para associar
}
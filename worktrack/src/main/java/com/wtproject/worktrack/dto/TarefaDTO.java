package com.wtproject.worktrack.dto;

import com.wtproject.worktrack.model.StatusTarefa;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private FuncionarioDTO funcionario;
    private LocalDateTime dataCriacao;
}

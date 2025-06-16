package com.wtproject.worktrack.dto;

import com.wtproject.worktrack.model.StatusTarefa;
import lombok.Data;

@Data
public class TarefaCreateDTO {
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private Long funcionarioId;  // só id para associação
}
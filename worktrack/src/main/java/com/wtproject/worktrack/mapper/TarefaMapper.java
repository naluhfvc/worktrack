package com.wtproject.worktrack.mapper;

import com.wtproject.worktrack.dto.TarefaCreateDTO;
import com.wtproject.worktrack.dto.TarefaDTO;
import com.wtproject.worktrack.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FuncionarioMapper.class)
public interface TarefaMapper {

    @Mapping(target = "funcionario", ignore = true)
    Tarefa toEntity(TarefaCreateDTO dto);

    TarefaDTO toDTO(Tarefa tarefa);
}
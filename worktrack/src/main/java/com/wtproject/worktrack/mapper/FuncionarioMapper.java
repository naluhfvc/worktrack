package com.wtproject.worktrack.mapper;

import com.wtproject.worktrack.dto.FuncionarioCreateDTO;
import com.wtproject.worktrack.dto.FuncionarioDTO;
import com.wtproject.worktrack.model.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SetorMapper.class)
public interface FuncionarioMapper {

    @Mapping(target = "setor", ignore = true) // vamos mapear setor manualmente para evitar loop
    Funcionario toEntity(FuncionarioCreateDTO dto);

    FuncionarioDTO toDTO(Funcionario funcionario);
}
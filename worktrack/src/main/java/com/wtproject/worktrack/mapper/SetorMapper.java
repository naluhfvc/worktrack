package com.wtproject.worktrack.mapper;

import com.wtproject.worktrack.dto.SetorCreateDTO;
import com.wtproject.worktrack.dto.SetorDTO;
import com.wtproject.worktrack.model.Setor;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SetorMapper {

    SetorDTO toDTO(Setor setor);

    Setor toEntity(SetorCreateDTO createDTO);
}
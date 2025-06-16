package com.wtproject.worktrack.service;

import com.wtproject.worktrack.dto.SetorDTO;
import com.wtproject.worktrack.mapper.SetorMapper;
import com.wtproject.worktrack.model.Setor;
import com.wtproject.worktrack.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private SetorMapper setorMapper;

    public List<SetorDTO> findAll() {
        return setorRepository.findAll()
                .stream()
                .map(setorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SetorDTO findById(Long id) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado: " + id));
        return setorMapper.toDTO(setor);
    }

    public SetorDTO save(SetorDTO dto) {
        Setor setor = setorMapper.toEntity(dto);
        setor = setorRepository.save(setor);
        return setorMapper.toDTO(setor);
    }

    public void delete(Long id) {
        setorRepository.deleteById(id);
    }
}

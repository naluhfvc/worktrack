package com.wtproject.worktrack.service;

import com.wtproject.worktrack.dto.SetorCreateDTO;
import com.wtproject.worktrack.dto.SetorDTO;
import com.wtproject.worktrack.mapper.SetorMapper;
import com.wtproject.worktrack.model.Setor;
import com.wtproject.worktrack.repository.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {

    private final SetorRepository setorRepository;
    private final SetorMapper setorMapper;

    public SetorService(SetorRepository setorRepository, SetorMapper setorMapper) {
        this.setorRepository = setorRepository;
        this.setorMapper = setorMapper;
    }

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

    public SetorDTO save(SetorCreateDTO dto) {
        Setor setor = setorMapper.toEntity(dto);
        setor = setorRepository.save(setor);
        return setorMapper.toDTO(setor);
    }

    public SetorDTO update(Long id, SetorCreateDTO dto) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        setor.setNome(dto.getNome());
        setor = setorRepository.save(setor);
        return setorMapper.toDTO(setor);
    }

    public void delete(Long id) {
        if (!setorRepository.existsById(id)) {
            throw new RuntimeException("Setor não encontrado");
        }
        setorRepository.deleteById(id);
    }
}

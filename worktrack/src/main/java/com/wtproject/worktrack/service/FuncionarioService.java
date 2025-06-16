package com.wtproject.worktrack.service;

import com.wtproject.worktrack.dto.FuncionarioCreateDTO;
import com.wtproject.worktrack.dto.FuncionarioDTO;
import com.wtproject.worktrack.mapper.FuncionarioMapper;
import com.wtproject.worktrack.model.Funcionario;
import com.wtproject.worktrack.model.Setor;
import com.wtproject.worktrack.repository.FuncionarioRepository;
import com.wtproject.worktrack.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository,
                              SetorRepository setorRepository,
                              FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.setorRepository = setorRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream()
                .map(funcionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        return funcionarioMapper.toDTO(funcionario);
    }

    public FuncionarioDTO save(FuncionarioCreateDTO createDTO) {
        Funcionario funcionario = funcionarioMapper.toEntity(createDTO);

        // Busca o Setor pelo id para associar
        Setor setor = setorRepository.findById(createDTO.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        funcionario.setSetor(setor);

        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(funcionario);
    }

    public FuncionarioDTO update(Long id, FuncionarioCreateDTO updateDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionario.setNome(updateDTO.getNome());
        funcionario.setCargo(updateDTO.getCargo());
        funcionario.setEmail(updateDTO.getEmail());

        Setor setor = setorRepository.findById(updateDTO.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        funcionario.setSetor(setor);

        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(funcionario);
    }

    public void delete(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }
        funcionarioRepository.deleteById(id);
    }
}
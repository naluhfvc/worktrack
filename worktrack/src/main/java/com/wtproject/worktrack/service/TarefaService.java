package com.wtproject.worktrack.service;

import com.wtproject.worktrack.dto.TarefaCreateDTO;
import com.wtproject.worktrack.dto.TarefaDTO;
import com.wtproject.worktrack.mapper.TarefaMapper;
import com.wtproject.worktrack.model.Funcionario;
import com.wtproject.worktrack.model.Tarefa;
import com.wtproject.worktrack.repository.FuncionarioRepository;
import com.wtproject.worktrack.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(
            TarefaRepository tarefaRepository,
            FuncionarioRepository funcionarioRepository,
            TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaDTO> findAll() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TarefaDTO findById(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return tarefaMapper.toDTO(tarefa);
    }

    public TarefaDTO save(TarefaCreateDTO dto) {
        Tarefa tarefa = tarefaMapper.toEntity(dto);

        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        tarefa.setFuncionario(funcionario);

        tarefa = tarefaRepository.save(tarefa);
        return tarefaMapper.toDTO(tarefa);
    }

    public TarefaDTO update(Long id, TarefaCreateDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());

        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        tarefa.setFuncionario(funcionario);

        tarefa = tarefaRepository.save(tarefa);
        return tarefaMapper.toDTO(tarefa);
    }

    public void delete(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }
        tarefaRepository.deleteById(id);
    }
}

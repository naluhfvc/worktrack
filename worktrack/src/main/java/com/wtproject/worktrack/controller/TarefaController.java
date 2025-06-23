package com.wtproject.worktrack.controller;

import com.wtproject.worktrack.dto.TarefaCreateDTO;
import com.wtproject.worktrack.dto.TarefaDTO;
import com.wtproject.worktrack.service.TarefaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@Tag(name = "Tarefas", description = "Endpoints para gerenciar Tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> create(@RequestBody TarefaCreateDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable Long id,
                                            @RequestBody TarefaCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.wtproject.worktrack.controller;

import com.wtproject.worktrack.dto.FuncionarioCreateDTO;
import com.wtproject.worktrack.dto.FuncionarioDTO;
import com.wtproject.worktrack.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
@Tag(name = "Funcionários", description = "Endpoints para gerenciar funcionários")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @Operation(summary = "Listar todos os funcionários")
    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar funcionário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Cadastrar novo funcionário")
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioCreateDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Operation(summary = "Atualizar funcionário existente")
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id,
                                                 @RequestBody FuncionarioCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Remover funcionário por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

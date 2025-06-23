package com.wtproject.worktrack.controller;

import com.wtproject.worktrack.dto.SetorCreateDTO;
import com.wtproject.worktrack.dto.SetorDTO;
import com.wtproject.worktrack.service.SetorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/setores")
@Tag(name = "Setores", description = "Endpoints para gerenciar Setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService service;

    @GetMapping
    public ResponseEntity<List<SetorDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetorDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SetorDTO> create(@RequestBody SetorCreateDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SetorDTO> update(@PathVariable Long id,
                                           @RequestBody SetorCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

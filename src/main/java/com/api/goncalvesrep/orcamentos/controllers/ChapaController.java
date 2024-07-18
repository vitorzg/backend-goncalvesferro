package com.api.goncalvesrep.orcamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.goncalvesrep.orcamentos.models.ChapaModel;
import com.api.goncalvesrep.orcamentos.services.ChapaService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/chapas")
public class ChapaController {

    @Autowired
    private ChapaService chapaService;

    @GetMapping
    public List<ChapaModel> getAllChapas() {
        return chapaService.getAllChapas();
    }

    @PostMapping
    public ChapaModel createChapa(@Valid @RequestBody ChapaModel chapa) {
        return chapaService.createChapa(chapa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapaModel> getChapaById(@PathVariable UUID id) {
        Optional<ChapaModel> chapa = chapaService.getChapaById(id);
        return chapa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChapaModel> updateChapa(@PathVariable UUID id, @Valid @RequestBody ChapaModel chapaDetails) {
        Optional<ChapaModel> updatedChapa = chapaService.updateChapa(id, chapaDetails);
        return updatedChapa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapa(@PathVariable UUID id) {
        chapaService.deleteChapa(id);
        return ResponseEntity.noContent().build();
    }
}

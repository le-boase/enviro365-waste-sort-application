package com.enviro.assessment.grad001.LesegoBoase.controller;

import com.enviro.assessment.grad001.LesegoBoase.entity.RecyclingTip;
import com.enviro.assessment.grad001.LesegoBoase.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
@Validated
public class RecyclingTipController {

    @Autowired
    private RecyclingTipRepository repository;

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        Optional<RecyclingTip> tip = repository.findById(id);
        return tip.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        RecyclingTip savedTip = repository.save(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tipDetails) {
        Optional<RecyclingTip> tip = repository.findById(id);
        if (tip.isPresent()) {
            RecyclingTip existingTip = tip.get();
            existingTip.setTip(tipDetails.getTip());
            RecyclingTip updatedTip = repository.save(existingTip);
            return ResponseEntity.ok(updatedTip);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
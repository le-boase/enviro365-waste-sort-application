package com.enviro.assessment.grad001.LesegoBoase.controller;

import com.enviro.assessment.grad001.LesegoBoase.entity.DisposalGuideline;
import com.enviro.assessment.grad001.LesegoBoase.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposal-guidelines")
@Validated
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineRepository repository;

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        Optional<DisposalGuideline> guideline = repository.findById(id);
        return guideline.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        DisposalGuideline savedGuideline = repository.save(guideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guidelineDetails) {
        Optional<DisposalGuideline> guideline = repository.findById(id);
        if (guideline.isPresent()) {
            DisposalGuideline existingGuideline = guideline.get();
            existingGuideline.setGuideline(guidelineDetails.getGuideline());
            DisposalGuideline updatedGuideline = repository.save(existingGuideline);
            return ResponseEntity.ok(updatedGuideline);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
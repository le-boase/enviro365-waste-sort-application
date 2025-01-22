package com.enviro.assessment.grad001.LesegoBoase.controller;

import com.enviro.assessment.grad001.LesegoBoase.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.LesegoBoase.entity.WasteCategory;
import com.enviro.assessment.grad001.LesegoBoase.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategoryDTO dto) {
        WasteCategory category = new WasteCategory(dto.getName(), dto.getDescription());
        WasteCategory savedCategory = service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }


    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        List<WasteCategory> categories = service.findAll();
        return ResponseEntity.ok(categories);
    }
    /*@GetMapping
    public ResponseEntity<List<WasteCategoryDTO>> getAllCategories() {
        List<WasteCategoryDTO> categories = service.findAll().stream()
                .map(category -> {
                    WasteCategoryDTO dto = new WasteCategoryDTO();
                    dto.setName(category.getName());
                    dto.setDescription(category.getDescription());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id) {
        WasteCategory category = service.findById(id);
        WasteCategoryDTO dto = new WasteCategoryDTO();
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
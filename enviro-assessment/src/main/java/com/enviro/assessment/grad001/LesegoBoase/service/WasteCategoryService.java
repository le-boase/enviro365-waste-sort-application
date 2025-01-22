package com.enviro.assessment.grad001.LesegoBoase.service;

import com.enviro.assessment.grad001.LesegoBoase.entity.WasteCategory;
import com.enviro.assessment.grad001.LesegoBoase.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.LesegoBoase.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository repository;

    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    public WasteCategory save(WasteCategory category) {
        return repository.save(category);
    }

    public List<WasteCategory> findAll() {
        return repository.findAll();
    }

    public WasteCategory findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found with id: " + id));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Waste category not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

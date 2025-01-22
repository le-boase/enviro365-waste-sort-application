package com.enviro.assessment.grad001.LesegoBoase.service;

import com.enviro.assessment.grad001.LesegoBoase.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.LesegoBoase.entity.DisposalGuideline;
import com.enviro.assessment.grad001.LesegoBoase.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public Optional<DisposalGuideline> getGuidelineById(Long id) {
        return repository.findById(id);
    }

    public DisposalGuideline createGuideline(DisposalGuidelineDTO guidelineDTO) {
        DisposalGuideline guideline = new DisposalGuideline(guidelineDTO.getGuideline());
        return repository.save(guideline);
    }

    public Optional<DisposalGuideline> updateGuideline(Long id, DisposalGuidelineDTO guidelineDTO) {
        return repository.findById(id).map(existingGuideline -> {
            existingGuideline.setGuideline(guidelineDTO.getGuideline());
            return repository.save(existingGuideline);
        });
    }

    public boolean deleteGuideline(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.enviro.assessment.grad001.LesegoBoase.service;

import com.enviro.assessment.grad001.LesegoBoase.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.LesegoBoase.entity.RecyclingTip;
import com.enviro.assessment.grad001.LesegoBoase.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> getTipById(Long id) {
        return repository.findById(id);
    }

    public RecyclingTip createTip(RecyclingTipDTO tipDTO) {
        RecyclingTip tip = new RecyclingTip(tipDTO.getTip());
        return repository.save(tip);
    }

    public Optional<RecyclingTip> updateTip(Long id, RecyclingTipDTO tipDTO) {
        return repository.findById(id).map(existingTip -> {
            existingTip.setTip(tipDTO.getTip());
            return repository.save(existingTip);
        });
    }

    public boolean deleteTip(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.enviro.assessment.grad001.LesegoBoase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.enviro.assessment.grad001.LesegoBoase.entity.WasteCategory;
import com.enviro.assessment.grad001.LesegoBoase.entity.RecyclingTip;
import com.enviro.assessment.grad001.LesegoBoase.entity.DisposalGuideline;
import com.enviro.assessment.grad001.LesegoBoase.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.LesegoBoase.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.LesegoBoase.repository.DisposalGuidelineRepository;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Application started successfully");
    }

    // CommandLineRunner to initialize the database with sample data
    @Bean
    CommandLineRunner runner(WasteCategoryRepository wasteCategoryRepository,
                             RecyclingTipRepository recyclingTipRepository,
                             DisposalGuidelineRepository disposalGuidelineRepository) {
        return args -> {
            WasteCategory category = new WasteCategory("Organic Waste", "Waste from plants and animals");
            wasteCategoryRepository.save(category);
            log.info("Saved WasteCategory: " + category);

            RecyclingTip tip = new RecyclingTip("Recycle paper and cardboard");
            recyclingTipRepository.save(tip);
            log.info("Saved RecyclingTip: " + tip);

            DisposalGuideline guideline = new DisposalGuideline("Dispose of batteries at designated collection points");
            disposalGuidelineRepository.save(guideline);
            log.info("Saved DisposalGuideline: " + guideline);
        };
    }
}
package com.enviro.assessment.grad001.LesegoBoase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.enviro.assessment.grad001.LesegoBoase.entity.WasteCategory;
import com.enviro.assessment.grad001.LesegoBoase.repository.WasteCategoryRepository;


@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Application started successfully");
    }
    @Bean
    CommandLineRunner runner(WasteCategoryRepository repository) {
        return args -> {
            WasteCategory category = new WasteCategory("Organic Waste", "Waste from plants and animals");
            repository.save(category);
            log.info("Saved WasteCategory: " + category);
        };
    }
}

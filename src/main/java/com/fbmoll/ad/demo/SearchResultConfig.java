package com.fbmoll.ad.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchResultConfig {
    Scraper resultScraper = new Scraper();

    @Bean
    CommandLineRunner commandLineRunner(
            SearchResultRepository resultRepository){
        return args -> {
            resultRepository.saveAll(resultScraper.searchResults());
        };
    }

}

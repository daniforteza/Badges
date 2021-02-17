package com.fbmoll.ad.demo.helper;

import com.fbmoll.ad.demo.document.SearchResultRepository;
import com.fbmoll.ad.demo.helper.Scraper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchResultConfig {
    Scraper resultScraper = new Scraper();

    @Bean
    CommandLineRunner commandLineRunner(
            SearchResultRepository repository){
        return args -> {
            repository.saveAll(resultScraper.searchResults());
        };
    }

}

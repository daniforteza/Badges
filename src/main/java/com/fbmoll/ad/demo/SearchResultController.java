package com.fbmoll.ad.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/SearchResult")

public class SearchResultController {
    private final SearchService searchService;

    @Autowired
    public SearchResultController(SearchService searchService){
        this.searchService = searchService;
    }
    @GetMapping
    public List<SearchResult> getResults(){
        return searchService.getResults();
    }

}


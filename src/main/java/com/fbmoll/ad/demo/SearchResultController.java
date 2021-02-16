package com.fbmoll.ad.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/searchresult")
public class SearchResultController {
    private final SearchService searchService;

    @Autowired
    public SearchResultController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping(path = "get")
    public List<SearchResult> getResults(){
        return searchService.getResults();
    }

}
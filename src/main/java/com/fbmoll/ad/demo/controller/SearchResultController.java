package com.fbmoll.ad.demo.controller;

import com.fbmoll.ad.demo.document.SearchResult;
import com.fbmoll.ad.demo.service.SearchService;
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

    @PostMapping
    public void registerNewResult(@RequestBody SearchResult result){
        searchService.addNewResult(result);
    }

    @DeleteMapping(path = "{resultId}")
    public void deleteResult(@PathVariable("resultId")Integer resultId){
        searchService.deleteResult(resultId);
    }

    @PutMapping (path = "{resultId}")
    public void updateResult(
            @PathVariable("resultId") Integer resultId,
            @RequestParam(required = false)String title,
            @RequestParam(required = false)String url){
        searchService.updateResult(resultId,title,url);
    }

}
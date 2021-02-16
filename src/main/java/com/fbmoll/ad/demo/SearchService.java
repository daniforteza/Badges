package com.fbmoll.ad.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchResultRepository searchResultRepository;

    @Autowired
    public SearchService(SearchResultRepository searchResultRepository){
        this.searchResultRepository = searchResultRepository;
    }

    public List<SearchResult> getResults(){
        return searchResultRepository.findAll();
    }
}

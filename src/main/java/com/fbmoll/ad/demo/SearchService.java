package com.fbmoll.ad.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewResult (SearchResult result){
        Optional<SearchResult> resultOptional=searchResultRepository
        .findResultById(result.getId());
    if (resultOptional.isPresent()){
        throw new IllegalStateException("error");
    }
    searchResultRepository.save(result);
    }
}

package com.fbmoll.ad.demo.service;
import com.fbmoll.ad.demo.document.SearchResult;
import com.fbmoll.ad.demo.document.SearchResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public  class SearchService {

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


    public void deleteResult(Integer resultId) {
               boolean exists = searchResultRepository.existsById(resultId);
               if (!exists){
                   throw new IllegalStateException("Result with id"+resultId+"does not exist");
               }
               searchResultRepository.deleteById(resultId);
    }
    @Transactional
    public  void updateResult(Integer resultId, String title, String url) {
        SearchResult searchResult = searchResultRepository.findResultById(resultId)
                .orElseThrow(()->new IllegalStateException(
                        "result with id"+resultId+"does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(searchResult.getTitle(),title)){
            searchResult.setTitle(title);
        }
        if (url != null && url.length() > 0 && !Objects.equals(searchResult.getUrl(),url)){
            searchResult.setUrl(url);
        }
    }

}

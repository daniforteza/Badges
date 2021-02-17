package com.fbmoll.ad.demo.document;


import com.fbmoll.ad.demo.document.SearchResult;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface SearchResultRepository extends JpaRepository<SearchResult,Integer> {
    //@Query("SELECT s FROM Proxy s WHERE s.ip = ?1")
    Optional<SearchResult> findResultById(Integer id);
}
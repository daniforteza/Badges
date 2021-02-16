package com.fbmoll.ad.demo;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SearchResultRepository extends JpaRepository<SearchResult,Integer> {

}
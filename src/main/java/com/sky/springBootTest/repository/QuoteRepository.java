package com.sky.springBootTest.repository;

import com.sky.springBootTest.model.Quote;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Query("SELECT q FROM Quote q WHERE q.quote LIKE %?1%")
    List<Quote> getContainingQuote(String word);
}

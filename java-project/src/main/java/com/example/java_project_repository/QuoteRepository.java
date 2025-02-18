package com.example.java_project_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.java_project_model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer>{

}
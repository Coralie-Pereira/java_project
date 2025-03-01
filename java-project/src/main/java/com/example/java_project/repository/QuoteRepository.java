package com.example.java_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_project.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer>{

}
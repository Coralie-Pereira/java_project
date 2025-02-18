package com.example.java_project_service;

import java.util.List;
import java.util.Random;

import com.example.java_project_model.Quote;
import com.example.java_project_repository.QuoteRepository;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {
	  private final QuoteRepository messageRepository;

	    public QuoteService(QuoteRepository messageRepository) {
	        this.messageRepository = messageRepository;
	    }

	 

	    public Quote quoteRandom() {
	    	
	    	List<Quote>RandomFindAll =  messageRepository.findAll();
	    	Random random = new Random();
	        return RandomFindAll.get(random.nextInt(RandomFindAll.size()));
	    }


}



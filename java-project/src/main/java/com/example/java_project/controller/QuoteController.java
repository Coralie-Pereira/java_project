package com.example.java_project.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_project.model.Quote;
import com.example.java_project.service.QuoteService;
@CrossOrigin(origins="*")

@RestController
public class QuoteController {
private final QuoteService quoteService;
	
	public QuoteController(QuoteService homeService) {
		this.quoteService = homeService;
	
	}
	
	@GetMapping("/quote")
	public Quote hello() {
		return quoteService.quoteRandom();
}
			
}




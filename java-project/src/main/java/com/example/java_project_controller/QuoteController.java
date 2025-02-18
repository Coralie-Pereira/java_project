package com.example.java_project_controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_project_model.Quote;
import com.example.java_project_service.QuoteService;
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




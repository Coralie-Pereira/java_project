package com.example.java_chat_project.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.java_chat_project.model.Message;
import com.example.java_chat_project.model.User;
import com.example.java_chat_project.service.ApiService;
import com.example.java_chat_project.service.ChatService;


@Controller



public class ChatController {
	  @Autowired
	    private ChatService chatService;
	  @Autowired
	  private ApiService apiService;
	  private User lastSavedUser;
	  
	  @GetMapping("/formMessage")
	  
	    public String getFormMessage( Model model) {
		  	
		  //  User user = chatService.findOrCreateUser(userName);
		  if ( lastSavedUser != null) {
			 
			    model.addAttribute("messageList", chatService.getListMessage(lastSavedUser));
			    return "formMessage";
		  } 
	        return "user";
	    }
	  
	  @GetMapping("/")
	  
	    public String getRedirection( Model model) {
		 lastSavedUser = null;
	       return "user";
		  
	    }

	    @PostMapping("/submitUser")
	    public String handleMessageFormSubmission(
	    		
	            @RequestParam("userName") String userName,
	            Model model) {

	        User user = chatService.findOrCreateUser(userName);
	        lastSavedUser = user;

	        return "redirect:/formMessage";
	    }

	    @PostMapping("/chatPrincipal")
	    public String routeMessageChatPrincipal(
	            @RequestParam("message") String message,
	            Model model) {

	        LocalDateTime date = LocalDateTime.now();
	        Message messageObj = new Message(message, date, lastSavedUser,apiService.getDataFromApi());
	        chatService.saveMessage(messageObj);

	     //   Optional<User> messageList = chatService.getMessageUser(user);
	   

	        return "redirect:/formMessage";
	    }
	
	
}

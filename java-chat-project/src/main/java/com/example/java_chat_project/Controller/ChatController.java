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
			  System.out.println("heelo" +lastSavedUser.getMessages());
			    model.addAttribute("messageList", chatService.getListMessage(lastSavedUser));
		  } else {
			    model.addAttribute("messageList", new ArrayList<>()); 
		  }
	        return "formMessage";
	    }

	    @PostMapping("/submitMessage")
	    public String handleMessageFormSubmission(
	            @RequestParam("userName") String userName,
	            @RequestParam("message") String message,
	            Model model) {

	        LocalDateTime date = LocalDateTime.now();
	        User user = chatService.findOrCreateUser(userName);
	        Message messageObj = new Message(message, date, user,"");
	        chatService.saveMessage(messageObj);

	        model.addAttribute("userName", userName);
	        model.addAttribute("message", message);
	        model.addAttribute("date", date);

	        List<Message> messageList = chatService.getAllMessages();
	        model.addAttribute("messageList", messageList);

	        return "allMessages";
	    }

	    @PostMapping("/chatPrincipal")
	    public String routeMessageChatPrincipal(
	            @RequestParam("userName") String userName,
	            @RequestParam("message") String message,
	            Model model) {

	        LocalDateTime date = LocalDateTime.now();
	        User user = chatService.findOrCreateUser(userName);
	        Message messageObj = new Message(message, date, user,apiService.getDataFromApi());
	        chatService.saveMessage(messageObj);

	        lastSavedUser = chatService.getMessageUser(user);
	        model.addAttribute("userName", userName);
	        model.addAttribute("message", message);
	        model.addAttribute("date", date);

	     //   Optional<User> messageList = chatService.getMessageUser(user);
	   

	        return "redirect:/formMessage";
	    }
	
	
}

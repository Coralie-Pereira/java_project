package com.example.java_chat_project.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.java_chat_project.model.Message;
import com.example.java_chat_project.model.User;
import com.example.java_chat_project.repository.MessageRepository;
import com.example.java_chat_project.repository.UserRepository;

@Service
public class ChatService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public ChatService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public User findOrCreateUser(String userName) {
        Optional<User> optionalUser = userRepository.findByName(userName);
        return optionalUser.orElseGet(() -> userRepository.save(new User(userName)));
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    public  User  getMessageUser(User user) {
    	 Optional<User> optionalUser = userRepository.findById(user.getId());
    	  return  optionalUser.orElseGet(() -> userRepository.save(new User(user.getName())));
    }
    
    public List<Message> getListMessage(User user){
    	return messageRepository.findByUser(user);
    }

}

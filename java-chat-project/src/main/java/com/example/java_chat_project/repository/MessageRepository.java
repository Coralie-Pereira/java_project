package com.example.java_chat_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_chat_project.model.Message;
import com.example.java_chat_project.model.User;



@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
	   List<Message> findByUser(User user);
}
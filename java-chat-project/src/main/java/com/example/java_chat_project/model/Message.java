package com.example.java_chat_project.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private LocalDateTime date;
    private String reponse;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Message() {}

    public Message(String content, LocalDateTime date, User user, String reponse) {
        this.content = content;
        this.date = date;
        this.user = user;
        this.reponse = reponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    
    public void setReponse(String reponse) {
    	this.reponse = reponse;
    }
    public String getReponse() {
        return reponse;
    }

}

package com.Ravi.notificationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String message;

    // getters, setters, default constructor, and parameterized constructor
    public String getUsername() {
        return username;
    }

    public String getMessage(){
        return message;
    }
}

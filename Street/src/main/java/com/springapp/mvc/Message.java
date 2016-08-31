package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("message")
public class Message {

    private String message;

    public Message() {
    }

    @Autowired
    public Message(@Value("Hello, Sasha Polovnev!")String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

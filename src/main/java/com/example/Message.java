package com.example;

import javax.persistence.*;

/**
 * Created by erikjakubowski on 12/21/16.
 */

@Entity
@Table(name="messages")

public class Message {

    public Message (){

    }

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String messageText;

    @ManyToOne
    User user;

    public Message(String messageText, User user) {
        this.messageText = messageText;
        this.user = user;
    }

    public Message(int id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }

    public Message(int id){
        this.id = id;
    }

    public Message (String messageText) {
        this.messageText = messageText;
    }
}
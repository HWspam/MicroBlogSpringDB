package com.example;

import javax.persistence.*;

/**
 * Created by erikjakubowski on 1/27/17.
 */

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;



    public User(){

    }
    @Column
    String name;


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

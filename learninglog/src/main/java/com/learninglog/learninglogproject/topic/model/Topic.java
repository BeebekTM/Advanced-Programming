package com.learninglog.learninglogproject.topic.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String name;
    private int user_Id;
    private Timestamp created_Date;

    public Topic(){}


    public Topic(int id, String name, int user_Id, Timestamp created_Date) {
        this.id = id;
        this.name = name;
        this.user_Id = user_Id;
        this.created_Date = created_Date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public Timestamp getCreated_Date() {
        return created_Date;
    }

    public void setCreated_Date(Timestamp created_Date) {
        this.created_Date = created_Date;
    }
}

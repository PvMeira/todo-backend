package com.pvmeira.TodoBackend.dto;

import java.util.Date;

public class TodoDTO {

    private Long id;
    private String username;
    private String description;
    private Boolean isDone;
    private Date targetData;
    
    public static synchronized TodoDTO create() {
        return new TodoDTO();
    }

    public TodoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Date getTargetData() {
        return targetData;
    }

    public void setTargetData(Date targetData) {
        this.targetData = targetData;
    }

    public TodoDTO withId(Long id) {
        this.id = id;
        return this;
    }

    public TodoDTO withUsername(String username) {
        this.username = username;
        return this;
    }

    public TodoDTO withDescription(String description) {
        this.description = description;
        return this;
    }

    public TodoDTO withDone(Boolean done) {
        isDone = done;
        return this;
    }

    public TodoDTO withTargetData(Date targetData) {
        this.targetData = targetData;
        return this;
    }
}

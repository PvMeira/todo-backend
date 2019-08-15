package com.pvmeira.TodoBackend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(  name = "USERNAME"
            , length = 120
            , nullable = false)
    private String username;
    @Column(  name = "DESCRIPTION"
            , length = 220
            , nullable = false)
    private String description;
    @Column(name = "IS_DONE")
    private Boolean isDone;
    @Column(name = "TARGET_DATA")
    private LocalDate targetData;


    public static synchronized Todo create() {
        return new Todo();
    }

    public Todo() {
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

    public LocalDate getTargetData() {
        return targetData;
    }

    public void setTargetData(LocalDate targetData) {
        this.targetData = targetData;
    }

    public Todo withId(Long id) {
        this.id = id;
        return this;
    }

    public Todo withUsername(String username) {
        this.username = username;
        return this;
    }

    public Todo withDescription(String description) {
        this.description = description;
        return this;
    }

    public Todo withDone(Boolean done) {
        isDone = done;
        return this;
    }

    public Todo withTargetData(LocalDate targetData) {
        this.targetData = targetData;
        return this;
    }
}

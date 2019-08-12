package com.pvmeira.TodoBackend.service;

import com.pvmeira.TodoBackend.dto.TodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    public List<TodoDTO> getTodos() {
        List<TodoDTO> result = new ArrayList<>(5);
        for (Integer i = 0; i < 5; i++) {
            result.add(TodoDTO.create()
                              .withId(Long.parseLong(i.toString()))
                              .withUsername("TB")
                              .withDone(Boolean.TRUE)
                              .withTargetData(new Date())
                              .withDescription("This is a teste with id " + i.toString()));
        }
        return result;
    }

    public void remove(String username, final Long id) {

    }

    public TodoDTO save(com.pvmeira.TodoBackend.dto.TodoDTO request) {
        return request;
    }
}

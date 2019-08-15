package com.pvmeira.TodoBackend.controller;

import com.pvmeira.TodoBackend.dto.TodoDTO;
import com.pvmeira.TodoBackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @GetMapping("/listby/{username}")
    public List<TodoDTO> listAllTodos(@PathVariable("username") String username) {
        return this.todoService.getTodos(username);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            this.todoService.remove(id);
        } catch (RuntimeException e) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, path = "/{username}")
    public ResponseEntity<TodoDTO> save(@PathVariable("username")String username,  @RequestBody TodoDTO request) {
        TodoDTO todoDTO = this.todoService.save(request.withUsername(username));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                                                                 .path("/{id}")
                                                                 .buildAndExpand(todoDTO.getId())
                                                                 .toUri())
                             .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable("id") Long id, @RequestBody TodoDTO request) {
        try {
            return ResponseEntity.ok(this.todoService.update(id, request));
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> findById (@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(this.todoService.findById(id));
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


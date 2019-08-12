package com.pvmeira.TodoBackend.controller;

import com.pvmeira.TodoBackend.dto.TodoDTO;
import com.pvmeira.TodoBackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @GetMapping("/listby/{username}")
    public List<TodoDTO> listAllTodos(@PathVariable("username") String username) {
        return this.todoService.getTodos();
    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<Void> delete(@PathVariable("username") String username, @PathVariable("id") Long id) {
        this.todoService.remove(username, id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{username}")
    public ResponseEntity<TodoDTO> save(@PathVariable("username")String username, TodoDTO request) {
        return ResponseEntity.ok(this.todoService.save(request));
    }

    @PutMapping("/{username}/{id}")
    public ResponseEntity<TodoDTO> update(@PathVariable("username") String username, @PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
    }
}

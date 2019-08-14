package com.pvmeira.TodoBackend.service;

import com.pvmeira.TodoBackend.dto.TodoDTO;
import com.pvmeira.TodoBackend.model.Todo;
import com.pvmeira.TodoBackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoDTO> getTodos(final String username) {
        List<Todo> list = this.makeCollection(this.todoRepository.findAllByUsername(username));
        return list.stream().map( a-> TodoDTO.create()
                                             .withId(a.getId())
                                             .withDescription(a.getDescription())
                                             .withDone(a.getDone())
                                             .withTargetData(a.getTargetData())
                                             .withUsername(a.getUsername()))
                            .collect(Collectors.toList());

    }

    public void remove(final Long id) throws RuntimeException{
        Optional<Todo> optionalTodo = this.todoRepository.findById(id);
        if (optionalTodo.isEmpty()) {throw new RuntimeException("No Todo was found with the given ID ");}
        this.todoRepository.delete(optionalTodo.get());
    }

    public TodoDTO save(TodoDTO request) {
        Todo todo = this.todoRepository.save(Todo.create()
                .withId(request.getId())
                .withDescription(request.getDescription())
                .withDone(Boolean.FALSE)
                .withTargetData(request.getTargetData())
                .withUsername(request.getUsername()));
        return request.withId(todo.getId());
    }


    public TodoDTO update(Long id, TodoDTO request) throws RuntimeException {
        boolean exists = this.todoRepository.existsById(id);
        if (exists) {
            return this.save(request.withId(id));
        } else {
            throw  new RuntimeException("No Todo was found for the given ID");
        }
    }

    public <E> List<E> makeCollection(Iterable<E> iter) {
        List<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }

    public TodoDTO findById(Long id) {
        Optional<Todo> optionalTodo = this.todoRepository.findById(id);
        if(optionalTodo.isEmpty()) {throw new RuntimeException("No Todo was found with that ID");}
        return TodoDTO.create()
                      .withId(optionalTodo.get().getId())
                      .withDescription(optionalTodo.get().getDescription())
                      .withUsername(optionalTodo.get().getUsername())
                      .withTargetData(optionalTodo.get().getTargetData())
                      .withDone(optionalTodo.get().getDone());
    }
}

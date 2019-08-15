package com.pvmeira.TodoBackend.repository;

import com.pvmeira.TodoBackend.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {


    Iterable<Todo> findAllByUsername(String username);
}

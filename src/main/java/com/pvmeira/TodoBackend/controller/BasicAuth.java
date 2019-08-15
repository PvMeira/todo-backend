package com.pvmeira.TodoBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basicauth")
public class BasicAuth {


    @GetMapping("/{username}/{password}")
    public ResponseEntity<Void> isAuthorized(@PathVariable("username") String username, @PathVariable("password") String password) {
        if (username.equalsIgnoreCase("tb") && password.equalsIgnoreCase("tb")) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

package com.api.goncalvesrep.orcamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.goncalvesrep.orcamentos.models.users.UserModel;
import com.api.goncalvesrep.orcamentos.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> findOneUsers(@Valid @PathVariable String id){
        UserDetails user = this.userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> findAllUsers(){
        List<UserModel> users = this.userService.findAll();
        return ResponseEntity.ok(users);
    }
}

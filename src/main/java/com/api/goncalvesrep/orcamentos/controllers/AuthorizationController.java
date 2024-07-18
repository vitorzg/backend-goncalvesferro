package com.api.goncalvesrep.orcamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.goncalvesrep.orcamentos.config.TokenService;
import com.api.goncalvesrep.orcamentos.models.users.AuthenticationDTO;
import com.api.goncalvesrep.orcamentos.models.users.LoginResponseDTO;
import com.api.goncalvesrep.orcamentos.models.users.RegisterDTO;
import com.api.goncalvesrep.orcamentos.models.users.UserModel;
import com.api.goncalvesrep.orcamentos.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data){

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generatedToken((UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody @Valid RegisterDTO data){
        if (repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String ePassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.login(), ePassword, data.name(), data.email(), data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
    
}

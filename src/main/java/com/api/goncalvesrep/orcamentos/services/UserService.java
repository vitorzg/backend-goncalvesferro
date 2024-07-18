package com.api.goncalvesrep.orcamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.goncalvesrep.orcamentos.models.users.UserModel;
import com.api.goncalvesrep.orcamentos.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserModel findById(String id) {
        Optional<UserModel> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public List<UserModel> findAll() {
        List<UserModel> Users = this.userRepository.findAll();
        return Users;
    }

    @Transactional
    public UserModel update(UserModel obj){
        UserModel newUser = findById(obj.getId());
        newUser.setLogin(obj.getLogin());
        newUser.setName(obj.getName());
        newUser.setEmail(obj.getEmail());
        newUser.setPassword(obj.getPassword());
        newUser.setRole(obj.getRole());
        return this.userRepository.save(newUser);
    }

    public void delete(String id){
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Unable to delete, check your database rules.");
        }
    }
}

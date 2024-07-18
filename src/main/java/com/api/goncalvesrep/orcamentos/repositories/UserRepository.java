package com.api.goncalvesrep.orcamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.api.goncalvesrep.orcamentos.models.users.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    
    UserDetails findByLogin(String login);
}
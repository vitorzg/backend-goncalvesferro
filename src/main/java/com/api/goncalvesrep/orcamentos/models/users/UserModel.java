package com.api.goncalvesrep.orcamentos.models.users;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USERS")
@Data
@NoArgsConstructor
public class UserModel implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user", unique = true)
    private String id;

    @Size(min = 3, max = 20)
    @NotBlank(message = "login field cannot be blank")
    @Column(unique = true)
    private String login;

    @NotBlank(message = "name field cannot be blank")
    private String name;

    @NotBlank(message = "login field cannot be blank")
    @Size(min = 8)
    private String password;

    @Email
    @NotBlank(message = "email field cannot be blank")
    private String email;

    @Column(name = "role_user")
    @JsonIgnore
    private UserRoleModel role;


    public UserModel(String login, String password, String name, String email, UserRoleModel role){
        this.login = login;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRoleModel.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

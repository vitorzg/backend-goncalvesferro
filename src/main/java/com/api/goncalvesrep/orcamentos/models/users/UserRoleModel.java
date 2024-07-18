package com.api.goncalvesrep.orcamentos.models.users;

public enum UserRoleModel {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRoleModel(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
    
}

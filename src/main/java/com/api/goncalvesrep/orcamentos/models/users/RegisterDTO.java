package com.api.goncalvesrep.orcamentos.models.users;

public record RegisterDTO(String login, String password, String name, String email, UserRoleModel role) {
}

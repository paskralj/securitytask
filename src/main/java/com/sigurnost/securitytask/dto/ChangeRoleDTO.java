package com.sigurnost.securitytask.dto;

import com.sigurnost.securitytask.entities.Role;

public class ChangeRoleDTO {

    private String username;
    private Role newRole;

    public ChangeRoleDTO(String username, Role newRole) {
        this.username = username;
        this.newRole = newRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getNewRole() {
        return newRole;
    }

    public void setNewRole(Role newrole) {
        this.newRole = newrole;
    }
}

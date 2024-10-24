package com.sigurnost.securitytask.entities;

public class ChangeRoleResponse {

    private String username;
    private Role oldRole;
    private Role newRole;

    public ChangeRoleResponse(String username, Role oldRole, Role newRole) {
        this.username = username;
        this.oldRole = oldRole;
        this.newRole = newRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getOldRole() {
        return oldRole;
    }

    public void setOldRole(Role oldRole) {
        this.oldRole = oldRole;
    }

    public Role getNewRole() {
        return newRole;
    }

    public void setNewRole(Role newRole) {
        this.newRole = newRole;
    }
}

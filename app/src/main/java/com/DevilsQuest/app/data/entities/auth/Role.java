package com.DevilsQuest.app.data.entities.auth;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

import com.DevilsQuest.app.data.entities.base.BaseEntity;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;  

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
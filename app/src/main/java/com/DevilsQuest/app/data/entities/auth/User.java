package com.DevilsQuest.app.data.entities.auth;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.entities.heroes.Hero;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    private static final long serialVersionUID = 1L;
    
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> authorities;

    @OneToMany(mappedBy = "user")
    private List<Hero> heroes;

    public User() {
        this.authorities = new ArrayList<>();
        this.heroes = new ArrayList<>();
    }

	public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Role> getAuthorities() {
        return this.authorities;
    }

    public void setAllAuthorties(List<Role> authorities) {
        this.authorities = authorities;
    }

    public void setSingleAuthority(Role role) {
        this.authorities.add(role);
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public void addHero(Hero hero) {
        this.heroes.add(hero);
    }

    @Override
    @Transient
	public boolean isAccountNonExpired() {
		return true;
	}

    @Override
    @Transient
	public boolean isAccountNonLocked() {
		return true;
	}

    @Override
    @Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

    @Override
    @Transient
	public boolean isEnabled() {
		return true;
	}
}
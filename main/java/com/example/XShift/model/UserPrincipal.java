package com.example.XShift.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Custom UserDetails implementation that wraps our User entity
 */
public class UserPrincipal implements UserDetails {

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // For now using a default "USER" role
        // Later you can replace this with user.getRoles() if your User has roles
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Modify based on your account expiration logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Modify based on your account locking logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Modify based on your credentials expiration logic
    }

    @Override
    public boolean isEnabled() {
        return true; // Modify based on your account activation logic
    }

    // Optional: Add a method to get the underlying User entity
    public User getUser() {
        return user;
    }
}
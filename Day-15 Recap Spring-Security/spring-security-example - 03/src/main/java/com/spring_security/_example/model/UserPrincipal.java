package com.spring_security._example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * UserPrincipal implements UserDetails to integrate our UserModel
 * with Spring Security for authentication and authorization.
 *
 * All user information required by Spring Security is exposed
 * through this class.
 */
public class UserPrincipal implements UserDetails {

    private final UserModel userModel;

    public UserPrincipal(UserModel userModel) {
        this.userModel = userModel;
    }

    /**
     * Returns the authorities granted to the user.
     * In our case, each user has a single role stored in UserModel.
     * Always prefix roles with "ROLE_" for Spring Security.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    /**
     * Returns the password used to authenticate the user.
     */
    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    /**
     * Returns the username used to authenticate the user.
     */
    @Override
    public String getUsername() {
        return userModel.getUsername();
    }

    /**
     * Indicates whether the user's account has expired.
     * Returning true means the account is valid (not expired).
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     * Returning true means the account is never locked.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) have expired.
     * Returning true means credentials are valid (not expired).
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     * Returning true means the user is active and can log in.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

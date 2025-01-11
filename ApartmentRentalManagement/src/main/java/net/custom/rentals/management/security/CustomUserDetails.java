package net.custom.rentals.management.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.custom.rentals.management.model.User;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {


	private static final long serialVersionUID = 4310437869096700725L;
	
	private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	return Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));
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
        return true; // Implement expiration logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement lock logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement expiration logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement enabled logic if needed
    }
}

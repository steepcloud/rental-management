package net.custom.rentals.management.service;

import net.custom.rentals.management.model.User;
import net.custom.rentals.management.repository.UserRepository;
import net.custom.rentals.management.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        /**
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername()) // set the username
                .password(user.getPassword()) // set the encoded password
                .authorities(user.getRole().name())
                .build();
        **/

        return new CustomUserDetails(user);
    }
}
package edu.osumc.bmi.ird.spring.tutorial.config;

import edu.osumc.bmi.ird.spring.tutorial.persistence.entity.User;
import edu.osumc.bmi.ird.spring.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by swang on 3/11/2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        return new SecurityUser(user);
    }
}

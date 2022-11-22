package com.notes.isd.services;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userRepo.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AppUserDetails(user);
    }

}

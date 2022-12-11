package com.notes.isd.services;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.repositories.UserAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private UserAccountRepository repos;

    public AppUserDetailsService(UserAccountRepository repos) {
        this.repos = repos;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = repos.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AppUserDetails(user);
    }

    public List<UserAccount> findAllUsers(){
        return repos.findAll();
    }

    public void registerNewUser(UserAccount user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getEncryptedPassword());
        user.setEncryptedPassword(encodedPassword);

        repos.save(user);
    }

}

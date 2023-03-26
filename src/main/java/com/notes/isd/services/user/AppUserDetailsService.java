package com.notes.isd.services.user;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.forms.UserForm;
import com.notes.isd.repositories.UserAccountRepository;
import com.notes.isd.services.user.AppUserDetails;
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

    public void registerNewUser(UserForm userForm){
        UserAccount user = new UserAccount();
        user.setLogin(userForm.getLogin());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setEncryptedPassword(encodedPassword);

        repos.save(user);
    }

}

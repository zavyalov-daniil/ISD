package com.notes.isd.services;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    public List<UserAccount> getAll(){
        return userAccountRepository.findAll();
    }

    public UserAccount save(UserAccount user) {
        return userAccountRepository.save(user);
    }

    public void delete(Integer id) {
        userAccountRepository.deleteById(id);
    }
}

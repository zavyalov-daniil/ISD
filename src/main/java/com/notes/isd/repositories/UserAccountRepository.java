package com.notes.isd.repositories;

import com.notes.isd.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    @Query("SELECT u FROM UserAccount u WHERE u.login = ?1")
    public UserAccount findByLogin(String email);
}

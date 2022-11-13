package com.notes.isd.repositories;

import com.notes.isd.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

}

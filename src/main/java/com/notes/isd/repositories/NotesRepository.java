package com.notes.isd.repositories;

import com.notes.isd.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<UserAccount, Integer> {
}

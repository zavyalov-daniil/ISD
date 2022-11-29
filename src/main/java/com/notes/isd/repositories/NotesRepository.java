package com.notes.isd.repositories;

import com.notes.isd.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Integer> {
}

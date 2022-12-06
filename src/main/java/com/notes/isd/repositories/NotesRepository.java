package com.notes.isd.repositories;

import com.notes.isd.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Integer> {
    @Query("SELECT n FROM Note n WHERE n.userId = ?1")
    public List<Note> findAllUserNotes(Integer userId);
}

package com.notes.isd.repositories;

import com.notes.isd.entities.Note;
import com.notes.isd.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tag, Integer> {
    @Query("SELECT n FROM Tag n WHERE n.title = ?1")
    public Tag findTagByTitle(String tagTitle);
}

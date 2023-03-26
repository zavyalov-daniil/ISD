package com.notes.isd.repositories;

import com.notes.isd.entities.Note;
import com.notes.isd.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tag, Integer> {
    @Query("SELECT n FROM Tag n WHERE n.title = ?1")
    public Tag findTagByTitle(String tagTitle);

    @Query("select t from Tag t join t.tagNotes n where n.id = :id")
    public List<Tag> findAllNoteTags(@Param("id") Integer noteId);
}

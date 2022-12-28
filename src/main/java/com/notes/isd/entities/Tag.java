package com.notes.isd.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true, length = 55)
    private String title;
    @ManyToMany(mappedBy = "notes")
    Set<Note> tagNotes;
    public Tag(){
        tagNotes = new HashSet<Note>();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Note> getTagNotes() {
        return tagNotes;
    }

    public void setTagNotes(Set<Note> tagNotes) {
        this.tagNotes = tagNotes;
    }

    public void addNoteToSet(Note note){
        tagNotes.add(note);
    }
}

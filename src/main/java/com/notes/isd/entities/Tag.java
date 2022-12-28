package com.notes.isd.entities;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true, length = 55)
    private String title;
//    @Column(nullable = false)
//    private Integer noteId;

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

//    public Integer getNoteId() {
//        return noteId;
//    }
//
//    public void setNoteId(Integer noteId) {
//        this.noteId = noteId;
//    }
}

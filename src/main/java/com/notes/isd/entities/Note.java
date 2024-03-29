package com.notes.isd.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 55)
    private String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Integer userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date date;
    @ManyToMany
    @JoinTable(
            name = "tags_notes",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tag> noteTags;
    public Note(){
        noteTags = new HashSet<Tag>();
    }
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUserId(Integer userId) {
        //Exception если пользователь не найден
        this.userId = userId;
    }

    public Set<Tag> getNoteTags() {
        return noteTags;
    }

    public void setNoteTags(Set<Tag> noteTags) {
        this.noteTags = noteTags;
    }

    public void addTagToSet(Tag tag){
        noteTags.add(tag);
    }
}

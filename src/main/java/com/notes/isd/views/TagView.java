package com.notes.isd.views;

public class TagView {
    private Integer id;
    private String title;
    private Integer noteId;

    public TagView(Integer id, String title, Integer noteId) {
        this.id = id;
        this.title = title;
        this.noteId = noteId;
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

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }
}

package com.notes.isd.forms;

public class TagForm {
    private String title;
    private Integer noteId;

    public TagForm(String title, Integer noteId) {
        this.title = title;
        this.noteId = noteId;
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

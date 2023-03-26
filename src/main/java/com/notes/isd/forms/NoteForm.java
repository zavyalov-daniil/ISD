package com.notes.isd.forms;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NoteForm {
    private String title;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    public NoteForm(){}
    public NoteForm(String title, String text, Date date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

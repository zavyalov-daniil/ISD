package com.notes.isd.views;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NoteView {
    private Integer id;
    private String title;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    public NoteView(){}
    public NoteView(Integer id, String title, String text, Date date) {
        this.id=id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

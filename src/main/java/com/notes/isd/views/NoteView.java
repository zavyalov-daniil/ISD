package com.notes.isd.views;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Date;

public class NoteView {
    private Integer id;
    private String title;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
//    private List<String> tags;
    String tags;
    public NoteView(){}
    public NoteView(Integer id, String title, String text, Date date, String tags) {
        this.id=id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}

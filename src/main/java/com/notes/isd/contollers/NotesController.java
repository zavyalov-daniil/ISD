package com.notes.isd.contollers;

import com.notes.isd.repositories.NotesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {
    NotesRepository repos;

    public NotesController(NotesRepository repos) {
        this.repos = repos;
    }

    @GetMapping("/notes")
    public String getNotes() {
        return "notes";
    }
}

package com.notes.isd.contollers;

import com.notes.isd.entities.Note;
import com.notes.isd.entities.UserAccount;
import com.notes.isd.repositories.NotesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NotesController {
    NotesRepository repos;

    public NotesController(NotesRepository repos) {
        this.repos = repos;
    }

    @GetMapping("/notes")
    public String getNotes(Model model) {
        model.addAttribute("new_note", new Note());
        model.addAttribute("note1", new Note());
        List<Note> notesList = repos.findAll();
        model.addAttribute("notesList", notesList);
        return "notes";
    }

    @PostMapping("/notes")
    public String addNote(@ModelAttribute Note note) {
        repos.save(note);
        return "redirect:/notes";
    }

    /*@GetMapping("/notes/new")
    public String getNewNoteForm() {
        return "notes";
    }*/

    @DeleteMapping("/notes/{id}")
    public String deleteNote(@PathVariable Integer id) {
        repos.deleteById(id);
        return "redirect:/notes";
    }
}

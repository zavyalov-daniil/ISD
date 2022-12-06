package com.notes.isd.contollers;

import com.notes.isd.entities.Note;
import com.notes.isd.repositories.NotesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesController {
    NotesRepository repos;

    public NotesController(NotesRepository repos) {
        this.repos = repos;
    }

    @GetMapping()
    public String getNotes(Model model) {
        model.addAttribute("new_note", new Note());
        List<Note> notesList = repos.findAll();
        model.addAttribute("notesList", notesList);
        return "notes";
    }

    @PostMapping()
    public String addNote(@ModelAttribute Note note) {
        repos.save(note);
        return "redirect:/notes";
    }

    /*@GetMapping("/notes/new")
    public String getNewNoteForm() {
        return "notes";
    }*/

    @RequestMapping ("/delete/{id}")
    public String deleteNote(@PathVariable Integer id) {
        repos.deleteById(id);
        return "redirect:/notes";
    }
}

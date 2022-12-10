package com.notes.isd.contollers;

import com.notes.isd.entities.Note;
import com.notes.isd.repositories.NotesRepository;
import com.notes.isd.services.ICurrentUserDetailsFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesController {
    NotesRepository repos;
    ICurrentUserDetailsFacade currentUserDetailsFacade;

    public NotesController(NotesRepository repos, ICurrentUserDetailsFacade currentUserDetailsFacade) {
        this.repos = repos;
        this.currentUserDetailsFacade = currentUserDetailsFacade;
    }

    @GetMapping()
    public String getNotes(Model model) {
        model.addAttribute("new_note", new Note());
        List<Note> notesList = repos.findAllUserNotes(currentUserDetailsFacade.getUserDetails().getUserId());
        model.addAttribute("notesList", notesList);
        return "notes";
    }

    @PostMapping()
    public String addNote(@ModelAttribute Note note) {
        Integer userId = currentUserDetailsFacade.getUserDetails().getUserId();
        note.setUserId(userId);
        repos.save(note);
        return "redirect:/notes";
    }

    @RequestMapping ("/delete/{id}")
    public String deleteNote(@PathVariable Integer id) {
        repos.deleteById(id);
        return "redirect:/notes";
    }
}

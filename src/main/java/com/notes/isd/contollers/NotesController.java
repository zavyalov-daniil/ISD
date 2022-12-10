package com.notes.isd.contollers;

import com.notes.isd.entities.Note;
import com.notes.isd.repositories.NotesRepository;
import com.notes.isd.services.ICurrentUserDetailsFacade;
import com.notes.isd.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesController {
    NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public String getNotes(Model model) {
        model.addAttribute("new_note", new Note());
        List<Note> notesList = noteService.findAllUserNotes();
        model.addAttribute("notesList", notesList);
        return "notes";
    }

    @PostMapping()
    public String addNote(@ModelAttribute Note note) {
        noteService.saveNote(note);
        return "redirect:/notes";
    }

    @RequestMapping ("/delete/{id}")
    public String deleteNote(@PathVariable Integer id) {
        noteService.deleteNoteById(id);
        return "redirect:/notes";
    }
}

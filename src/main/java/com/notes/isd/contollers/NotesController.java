package com.notes.isd.contollers;

import com.notes.isd.entities.Tag;
import com.notes.isd.forms.NoteForm;
import com.notes.isd.forms.TagForm;
import com.notes.isd.views.NoteView;
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
        model.addAttribute("new_note", new NoteView());
        List<NoteView> notesList = noteService.findAllUserNotes();
        model.addAttribute("notesList", notesList);
        model.addAttribute("new_tag", new TagForm());
        return "notes";
    }

    @PostMapping()
    public String addNote(@ModelAttribute NoteForm noteForm) {
        noteService.saveNote(noteForm);
        return "redirect:/notes";
    }
    @PostMapping("/addTag")
    public String addTagToNote(@ModelAttribute TagForm tagForm, @ModelAttribute Integer id){
        noteService.addTagToNote(tagForm, id);
        return "redirect:/notes";
    }

    @RequestMapping ("/delete/{id}")
    public String deleteNote(@PathVariable Integer id) {
        noteService.deleteNoteById(id);
        return "redirect:/notes";
    }
}

package com.notes.isd.services;

import com.notes.isd.entities.Note;
import com.notes.isd.forms.NoteForm;
import com.notes.isd.views.NoteView;
import com.notes.isd.repositories.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    NotesRepository repos;
    ICurrentUserDetailsFacade currentUserDetailsFacade;

    public NoteService(NotesRepository repos, ICurrentUserDetailsFacade currentUserDetailsFacade) {
        this.repos = repos;
        this.currentUserDetailsFacade = currentUserDetailsFacade;
    }

    public List<NoteView> findAllUserNotes() {
        List<Note> noteList = repos.findAllUserNotes(currentUserDetailsFacade.getUserDetails().getUserId());
        List<NoteView> noteViewList = new ArrayList<>();
        for (Note note:noteList) {
            noteViewList.add(noteEntityToView(note));
        }
        return noteViewList;
    }

    public NoteView noteEntityToView(Note note) {
        return new NoteView(note.getId(), note.getTitle(), note.getText());
    }
    public void saveNote(NoteForm noteForm) {
        Integer userId = currentUserDetailsFacade.getUserDetails().getUserId();
        Note note = new Note();
        note.setText(noteForm.getText());
        note.setTitle(noteForm.getTitle());
        note.setUserId(userId);
        repos.save(note);
    }
    public void deleteNoteById(Integer id) {
        repos.deleteById(id);
    }
}

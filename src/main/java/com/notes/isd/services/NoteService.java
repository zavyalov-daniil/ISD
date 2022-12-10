package com.notes.isd.services;

import com.notes.isd.entities.Note;
import com.notes.isd.repositories.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    NotesRepository repos;
    ICurrentUserDetailsFacade currentUserDetailsFacade;

    public NoteService(NotesRepository repos, ICurrentUserDetailsFacade currentUserDetailsFacade) {
        this.repos = repos;
        this.currentUserDetailsFacade = currentUserDetailsFacade;
    }

    public List<Note> findAllUserNotes() {
        return repos.findAllUserNotes(currentUserDetailsFacade.getUserDetails().getUserId());
    }
    public void saveNote(Note note) {
        Integer userId = currentUserDetailsFacade.getUserDetails().getUserId();
        note.setUserId(userId);
        repos.save(note);
    }
    public void deleteNoteById(Integer id) {
        repos.deleteById(id);
    }
}

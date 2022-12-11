package com.notes.isd.services;

import com.notes.isd.entities.Note;
import com.notes.isd.models.NoteModel;
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

    public List<NoteModel> findAllUserNotes() {
        List<Note> noteList = repos.findAllUserNotes(currentUserDetailsFacade.getUserDetails().getUserId());
        List<NoteModel> noteModelList = new ArrayList<>();
        for (Note note:noteList) {
            noteModelList.add(new NoteModel(note.getId(), note.getTitle(), note.getText()));
        }
        return noteModelList;
    }
    public void saveNote(NoteModel noteModel) {
        Integer userId = currentUserDetailsFacade.getUserDetails().getUserId();
        Note note = new Note();
        note.setText(noteModel.getText());
        note.setTitle(noteModel.getTitle());
        note.setUserId(userId);
        repos.save(note);
    }
    public void deleteNoteById(Integer id) {
        repos.deleteById(id);
    }
}

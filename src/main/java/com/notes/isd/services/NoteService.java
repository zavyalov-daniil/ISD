package com.notes.isd.services;

import com.notes.isd.entities.Note;
import com.notes.isd.entities.Tag;
import com.notes.isd.forms.NoteForm;
import com.notes.isd.forms.TagForm;
import com.notes.isd.repositories.TagsRepository;
import com.notes.isd.views.NoteView;
import com.notes.isd.repositories.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    NotesRepository repos;
    TagsRepository tagRepos;
    ICurrentUserDetailsFacade currentUserDetailsFacade;

    public NoteService(NotesRepository repos, TagsRepository tagRepos, ICurrentUserDetailsFacade currentUserDetailsFacade) {
        this.repos = repos;
        this.tagRepos = tagRepos;
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
        List<Tag> tags = tagRepos.findAllNoteTags(note.getId());
        String tagsTitles = "";
//        List<String> tagsTitles = new ArrayList<String>();
        for (Tag tag : tags) {
            tagsTitles += tag.getTitle() + "\n" ;
        }
        return new NoteView(note.getId(), note.getTitle(), note.getText(), note.getDate(), tagsTitles);
    }
    public void saveNote(NoteForm noteForm) {
        Integer userId = currentUserDetailsFacade.getUserDetails().getUserId();
        Note note = new Note();
        note.setText(noteForm.getText());
        note.setTitle(noteForm.getTitle());
        note.setUserId(userId);
        note.setDate(noteForm.getDate());
        repos.save(note);
    }
    public void deleteNoteById(Integer id) {
        repos.deleteById(id);
    }

    public void addTagToNote(TagForm tagForm){
        Tag tag = tagRepos.findTagByTitle(tagForm.getTitle());
        if (tag == null){
            tag = new Tag();
            tag.setTitle(tagForm.getTitle());
        }
        Note note = repos.getReferenceById(tagForm.getNoteId());
        tag.addNoteToSet(note);
        tagRepos.save(tag);
        note.addTagToSet(tag);
        repos.save(note);
    }
}

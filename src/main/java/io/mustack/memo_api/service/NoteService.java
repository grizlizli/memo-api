package io.mustack.memo_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mustack.memo_api.api.model.Note;
import io.mustack.memo_api.api.repository.NoteRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // private List<Note> notesList;

    public NoteService() {
        // notesList = new ArrayList<>();

        // Note note1 = new Note(1, "Setup git for API", "init github repository for BE");
        // Note note2 = new Note(2, "Setup git for FE", "init github repository for FE");

        // notesList.addAll(Arrays.asList(note1, note2));
    }

    // public Optional<Note> getNote(Integer id) {
    //     Optional optional = Optional.empty();
    //     for (Note note: notesList) {
    //         if (id == note.getId()) {
    //             optional = Optional.of(note);
    //             return optional;
    //         }
    //     }

    //     return optional;
    // }

    public Optional<Note> getById(String id) {
        return noteRepository.findById(id);
    }

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}

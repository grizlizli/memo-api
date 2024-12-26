package io.mustack.memo_api.service;

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

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> getById(String id) {
        return noteRepository.findById(id);
    }

    public List<Note> findAll() {
        return noteRepository.findActiveNotes();
    }
}

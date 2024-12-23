package io.mustack.memo_api.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.mustack.memo_api.api.model.Note;
import io.mustack.memo_api.service.NoteService;

@RestController
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public Note getNote(@RequestParam Integer id) {
        Optional note = noteService.getNote(id);
        if (note.isPresent()) {
            return (Note) note.get();
        }

        return null;
    }
}

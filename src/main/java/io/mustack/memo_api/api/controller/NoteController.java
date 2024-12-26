package io.mustack.memo_api.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.mustack.memo_api.api.model.Note;
import io.mustack.memo_api.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // @Autowired
    // public NoteController(NoteService noteService) {
    //     this.noteService = noteService;
    // }

    // @GetMapping("/notes")
    // public Note getNote(@RequestParam Integer id) {
    //     Optional note = noteService.getNote(id);
    //     if (note.isPresent()) {
    //         return (Note) note.get();
    //     }

    //     return null;
    // }

    @GetMapping
    public List<Note> getNotes() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable String id) {
        return noteService.getById(id).orElse(null);
    }

    // @PatchMapping("/{id}")
    // public Note updateNoteById(@PathVariable String id, @RequestBody Note note) {
    //     System.out.println(id);
    //     return noteService.updateById(id, note).orElse(null);
    // }

    @PostMapping
    public Note createUser(@RequestBody Note note) {
        System.out.println("grizli");
        System.out.println(note.getTitle());
        return noteService.create(note);
    }
    
}

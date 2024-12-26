package io.mustack.memo_api.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @GetMapping
    public List<Note> getNotes() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable String id) {
        return noteService.getById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        Optional<Note> optionalNote = noteService.getById(id);

        if (optionalNote.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Note note = optionalNote.get();

        payload.forEach((key, value) -> {
            switch (key) {
                case "title":
                    note.setTitle((String) value);
                    break;
                case "content":
                    note.setContent((String) value);
                    break;
                case "deleted":
                    System.out.println(value);
                    note.setDeleted((Boolean) value);
                    break;
                case "id":
                    throw new IllegalArgumentException("Cannot update id");
                default:
                    throw new IllegalArgumentException("Invalid object field " + key);
            }
        });

        Note updatedNote = noteService.save(note);

        return ResponseEntity.ok(updatedNote);
    }

    @PostMapping
    public Note createUser(@RequestBody Note note) {
        note.setDeleted(false);
        return noteService.save(note);
    }
    
}

package io.mustack.memo_api.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.mustack.memo_api.api.model.Note;

public interface NoteRepository extends MongoRepository<Note, String> {
   Optional<Note> findById(String id);
}

package io.mustack.memo_api.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.mustack.memo_api.api.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}

package com.lucasnunes.workshopmongo.repository;

import com.lucasnunes.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<User, String> {

}

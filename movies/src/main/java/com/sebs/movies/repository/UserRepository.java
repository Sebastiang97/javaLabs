package com.sebs.movies.repository;

import com.sebs.movies.documents.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {

}

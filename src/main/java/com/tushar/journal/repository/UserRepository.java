package com.tushar.journal.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tushar.journal.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{
	
	User findByUsername(String username);
}

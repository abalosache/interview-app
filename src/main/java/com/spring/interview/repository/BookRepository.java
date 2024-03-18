package com.spring.interview.repository;

import com.spring.interview.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository  extends MongoRepository<Book, String> {
}

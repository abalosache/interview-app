package com.spring.interview.service;

import com.spring.interview.model.Book;
import com.spring.interview.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book getBook(String id) {
        return bookRepository.findById(id).orElse(null);
    }
}

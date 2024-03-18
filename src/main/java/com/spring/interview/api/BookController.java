package com.spring.interview.api;

import com.spring.interview.model.Book;
import com.spring.interview.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    /*
    * A method for add a new review /books/{id}/review
    * Return 202 created for success
    * Return 404 in case the book that we need for reviews is not there
    * */

    /*
     * A method for get all reviews for given book id /books/{id}/reviews
     * Return 200 ok for success and a list of reviews
     * Return an empty list in case nothing is there
     * */
}

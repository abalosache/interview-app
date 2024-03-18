package com.spring.interview.service;

import com.spring.interview.model.Book;
import com.spring.interview.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void shouldGetBookById() {
        String id = "1";
        Book book = new Book(id, "Amintiri din programare", "Mihai Eminescu", 120);

        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        Book result = bookService.getBook(id);

        assertNotNull(result);
        assertEquals(book, result);
    }

    @Test
    public void shouldGetNullBookById() {
        String id = "1";

        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.empty());
        Book result = bookService.getBook(id);

        assertNull(result);
    }

}

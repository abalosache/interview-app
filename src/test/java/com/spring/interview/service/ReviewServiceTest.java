package com.spring.interview.service;

import com.spring.interview.dto.NewReview;
import com.spring.interview.dto.ReviewDTO;
import com.spring.interview.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void shouldAddNewComment() {
        String id = "1";
        Book book = new Book(id, "Amintiri din programare", "Mihai Eminescu", 120);
        NewReview review = new NewReview("Is good", "john_123");

        Mockito.when(bookService.getBook(id)).thenReturn(book);

        String result = reviewService.addReview(review, id);

        assertNotNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsException_null_id() {
        String id = "1";
        NewReview review = new NewReview("Is good", "john_123");

        String result = reviewService.addReview(review, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsException_null_book() {
        String id = "1";
        NewReview review = new NewReview("Is good", "john_123");

        Mockito.when(bookService.getBook(id)).thenReturn(null);

        String result = reviewService.addReview(review, id);
    }

    @Test
    public void shouldGetBookComments() {
        String id = "1";
        Book book = new Book(id, "Amintiri din programare", "Mihai Eminescu", 120);
        List<ReviewDTO> reviews = List.of(
                new ReviewDTO("1", "good", "mikw_0034", LocalDateTime.now()),
                new ReviewDTO("2", "not good", "alala_john", LocalDateTime.now())
        );

        Mockito.when(bookService.getBook(id)).thenReturn(book);

        List<ReviewDTO> result = reviewService.getReviews(id);

        assertNotNull(result);
        assertEquals(result.size(), reviews.size());
    }

    @Test
    public void shouldGetEmptyList() {
        String id = "1";

        List<ReviewDTO> result = reviewService.getReviews(id);

        assertNotNull(result);
        assertEquals(result.size(), 0);
    }
}

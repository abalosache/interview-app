package com.spring.interview.api;

import com.spring.interview.dto.NewReview;
import com.spring.interview.dto.ReviewDTO;
import com.spring.interview.model.Book;
import com.spring.interview.service.BookService;
import com.spring.interview.service.ReviewService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private ReviewService reviewService;


    @Test
    public void shouldGetBookById() throws Exception {
        String id = "1";
        Book book = new Book(id, "Amintiri din programare", "Mihai Eminescu", 120);

        Mockito.when(bookService.getBook(id)).thenReturn(book);

        mockMvc.perform(get("/books/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(book.id())))
                .andExpect(jsonPath("$.name", is(book.name())));
    }

    @Test
    public void shouldGetBookByIdNullBook() throws Exception {
        String id = "1";

        Mockito.when(bookService.getBook(id)).thenReturn(null);

        mockMvc.perform(get("/books/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddNewReview() throws Exception {
        String id = "1";
        String review_id = "2";
        NewReview review = new NewReview("Is good", "john_123");

        Mockito.when(reviewService.addReview(review, id)).thenReturn(review_id);

        mockMvc.perform(get("/books/{id}/review", id))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", is(review_id)));
    }

    @Test
    public void shouldGive404OnAddReview() throws Exception {
        String id = "1";
        NewReview review = new NewReview("Is good", "john_123");

        Mockito.when(reviewService.addReview(review, id)).thenThrow(IllegalArgumentException.class);

        mockMvc.perform(get("/books/{id}/review", id))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", equalTo("Book not found!")));
    }


    @Test
    public void shouldGetBookReviews() throws Exception {
        String id = "1";
        List<ReviewDTO> reviews = List.of(
                new ReviewDTO("1", "good", "mikw_0034", LocalDateTime.now()),
                new ReviewDTO("2", "not good", "alala_john", LocalDateTime.now())
        );

        Mockito.when(reviewService.getReviews(id)).thenReturn(reviews);

        mockMvc.perform(get("/books/{id}/reviews", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[1].id", is(reviews.get(1).id())));
    }


}

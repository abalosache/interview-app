package com.spring.interview.service;

import com.spring.interview.dto.NewReview;
import com.spring.interview.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    /*
    * throws IllegalArgumentException in case id is null or we cannot found the book
    * return id of saved comment
    * */
    public String addReview(NewReview newReview, String id) {
        throw new UnsupportedOperationException("We need to have an implementation");
    }

    public List<ReviewDTO> getReviews(String id) {
        throw new UnsupportedOperationException("We need to have an implementation");
    }
}

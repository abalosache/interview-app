package com.spring.interview.dto;

import java.time.LocalDateTime;

public record ReviewDTO(String id, String comment, String author, LocalDateTime postDate) {
}

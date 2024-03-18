package com.spring.interview.model;

import jakarta.persistence.Id;

public record Book(@Id String id, String name, String author, Integer price) {
}

package com.together.Modoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public void update(Category category) {
    }
}

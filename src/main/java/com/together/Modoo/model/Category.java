package com.together.Modoo.model;

import com.together.Modoo.dto.request.RequestBoard;
import com.together.Modoo.dto.response.ResponseCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public Category(RequestBoard requestBoard) {
        this.title = requestBoard.getTitle();
    }

    public ResponseCategory toDto() {
        return ResponseCategory.builder()
                .id(id)
                .title(title)
                .build();
    }

    public void update(Category category) {
    }
}

package com.together.Modoo.service;

import com.together.Modoo.model.Category;
import com.together.Modoo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isEmpty())
            throw new RuntimeException();

        Category category1 = optionalCategory.get();
        category1.update(category);
    }

    public void delete(Long id) {
        return;
    }
}

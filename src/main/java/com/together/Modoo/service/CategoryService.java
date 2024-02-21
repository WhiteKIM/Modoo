package com.together.Modoo.service;

import com.together.Modoo.dto.request.category.RequestCategory;
import com.together.Modoo.dto.response.category.ResponseCategory;
import com.together.Modoo.model.Category;
import com.together.Modoo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void save(RequestCategory category) {
        categoryRepository.save(new Category(category));
    }

    public ResponseCategory getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new).toDto();
    }

    public void update(Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isEmpty())
            throw new RuntimeException();

        Category category1 = optionalCategory.get();
        category1.update(category);
    }

    // 실제로 지워도 무방한 데이터
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<ResponseCategory> getAll() {
        return categoryRepository.findAll().stream().map(Category::toDto).toList();
    }
}

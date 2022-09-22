package com.sistema.evaluacion.services;


import com.sistema.evaluacion.models.entities.Category;

import java.util.Set;

public interface ICategoryService {
    Category addCategory(Category category);

    Category updateCategory(Category category);

    Set<Category> getCategories();

    Category getCategory(Long id);

    void deleteCategory(Long id);
}

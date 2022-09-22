package com.sistema.evaluacion.services.impl;

import com.sistema.evaluacion.models.entities.Category;
import com.sistema.evaluacion.repositories.ICategoryRepository;
import com.sistema.evaluacion.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        if (!categoryRepository.findById(category.getId()).isPresent()) {
            throw new EntityNotFoundException("La categoria que intenta actualizar no existe");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<Category>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long id) {

        if (!categoryRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("La categoria que solicita no existe");
        }
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("La categoria que intenta eliminar no existe");
        }
        categoryRepository.deleteById(id);
    }
}

package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.models.entities.Category;
import com.sistema.evaluacion.services.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/")
@Api(tags = "Controlador de Categoria")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("category/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Consultar una categoria")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("list/category")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Consultar lista categorias")
    public Set<Category> listCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("category")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Guardar una categoria")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("category")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualizar una categoria")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Eliminar una categoria")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}

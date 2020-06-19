/*
package com.startup.OnlineStore.service;

import com.startup.OnlineStore.Enum.Category;
import com.startup.OnlineStore.model.Item;
import com.startup.OnlineStore.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoryRepo.findById(categoryId);
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepo.findAll();
    }

    public void addItemToCategory(int categoryId,Item item){
            Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
            optionalCategory.ifPresent(cat -> {
                cat.addItems(item);
                item.setCategory(cat);
        });
    }
}
*/

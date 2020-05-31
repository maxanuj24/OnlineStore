package com.startup.OnlineStore.service;

import com.startup.OnlineStore.model.Category;
import com.startup.OnlineStore.model.Item;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public void addCategory(Category category);

    public Optional<Category> getCategory(int categoryId);

    public List<Category> getCategory();

    public void addItemToCategory(int categoryId, Item item) ;
}
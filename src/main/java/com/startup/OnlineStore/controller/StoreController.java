package com.startup.OnlineStore.controller;

import com.startup.OnlineStore.model.Category;
import com.startup.OnlineStore.model.Item;
import com.startup.OnlineStore.repo.CategoryRepo;
import com.startup.OnlineStore.repo.ItemRepo;
import com.startup.OnlineStore.service.CategoryService;
import com.startup.OnlineStore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/showItems")
    public String get(){
            return "Items Controller";
    }

    @GetMapping("/getItem/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("itemId") int itemId){
        Item item = itemRepo.getItem(itemId);
        return new ResponseEntity<Item>(item,HttpStatus.CREATED);
    }

     @GetMapping("/getItems")
     public ResponseEntity<List<Item>> getItems(){
        List<Item> items = itemRepo.getAllItems();
        return new ResponseEntity<List<Item>>(items,HttpStatus.FOUND);
     }

     @PostMapping("/addItem")
     public void addItem(@RequestBody Item item){
        itemRepo.addItem(item);
    }


    @GetMapping("/healthCheckCategory")
    public String getCategory(){
        return "Category Controller Alive";
    }

    @GetMapping("/getCategory/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") int categoryId){
        Category category = categoryRepo.getCategoryById(categoryId);
        return new ResponseEntity<Category>(category,HttpStatus.FOUND);
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryRepo.getCategories();
        return new ResponseEntity<List<Category>>(categories,HttpStatus.FOUND);
    }
    @PostMapping(value = "/addCategory",consumes = "application/json")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        categoryRepo.addCategory(category);
        return new ResponseEntity<Category>(category,HttpStatus.CREATED);
    }
    @PostMapping("/updateCategory")
    public void updateCategory(@RequestBody Category category){
        categoryRepo.addCategory(category);
    }

}

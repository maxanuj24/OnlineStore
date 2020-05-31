package com.startup.OnlineStore.controller;

import com.startup.OnlineStore.model.Category;
import com.startup.OnlineStore.model.Item;
import com.startup.OnlineStore.model.Order;
import com.startup.OnlineStore.model.User;
import com.startup.OnlineStore.repo.CategoryRepo;
import com.startup.OnlineStore.repo.ItemRepo;
import com.startup.OnlineStore.repo.OrderRepo;
import com.startup.OnlineStore.repo.UserRepo;
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
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

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

    @GetMapping("/showOrders")
    public String showOrder(){
        return "Orders Controller";
    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") int orderId){
        Order order = orderRepo.getOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> order = orderRepo.getAllOrders();
        return new ResponseEntity<List<Order>>(order,HttpStatus.FOUND);
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order){
        orderRepo.addOrder(order);
    }

    @GetMapping("/healthCheckUser")
    public String getUser(){
        return "User Controller Alive";
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
        User category = userRepo.getUserById(userId);
        return new ResponseEntity<User>(category,HttpStatus.FOUND);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userRepo.getUsers();
        return new ResponseEntity<List<User>>(users,HttpStatus.FOUND);
    }
    @PostMapping(value = "/addUser",consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userRepo.addUser(user);
        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        userRepo.addUser(user);
    }

}

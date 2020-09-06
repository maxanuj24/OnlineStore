package com.startup.OnlineStore.controller;

import com.startup.OnlineStore.OnlineStoreApplication;
import com.startup.OnlineStore.model.*;
import com.startup.OnlineStore.repo.*;

import com.sun.rmi.rmid.ExecOptionPermission;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
/*
import org.apache.log4j.Level;
import org.apache.log4j.Logger;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class StoreController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MerchantRepo merchantRepo;
    @Autowired
    LoginRepo loginRepo;
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

//---------------------------------------------------------------------------

    @GetMapping("/healthCheckCategory")
    public String getCategory(){
        return "Category Controller Alive";
    }

//---------------------------------------------------------------------------

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

    @GetMapping("/getAllOrders/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable("userId") int userId){
        List<Order> orders = userRepo.getOrdersByUserId(userId);
        if(orders!=null)
            return  new ResponseEntity<List<Order>>(orders,HttpStatus.FOUND);
        else
            return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getOrder/{userId}/{orderId}")
    public ResponseEntity<Order> getOrdersByOrderId(@PathVariable("userId") int userId,@PathVariable("orderId") int orderId){
        Order order = userRepo.getOrderByUserIdAndOrderId(userId,orderId);
        if(order!=null)
            return  new ResponseEntity<Order>(order,HttpStatus.FOUND);
        else
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getOrdersByMerchant/{merchantId}")
    public ResponseEntity<List<Order>> getOrdersByMerchantId(@PathVariable("merchantId") int merchantId){

        List<Order> orders = orderRepo.getOrdersByMerchantId(merchantId);
        if(orders!=null)
            return  new ResponseEntity<List<Order>>(orders,HttpStatus.FOUND);
            return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getOrdersByMerchantAndStatus/{merchantId}/{status}")
    public ResponseEntity<List<Order>> getOrdersByMerchantIdAndStatus(@PathVariable("merchantId") int merchantId,@PathVariable("status") String status){
        List<Order> orders =  orderRepo.getOrdersByMerchantIdAndStatus(merchantId,status);
        if(orders!=null)
        return new ResponseEntity<List<Order>>(orders,HttpStatus.FOUND);
        return new ResponseEntity<List<Order>>(orders,HttpStatus.NOT_FOUND);
    }
//---------------------------------------------------------------------------


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
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        userRepo.addUser(user);
    }

    //---------------------------------------------------------------------------

    @GetMapping("/showAddress")
    public String showAddress(){
        return "Address Controller";
    }

    @GetMapping("/getAddress/{addressId}")
    public ResponseEntity<Address> getAddress(@PathVariable("addressId") int addressId){
        Address address = addressRepo.getAddress(addressId);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    @GetMapping("/getAddresses")
    public ResponseEntity<List<Address>> getAddresses(){
        List<Address> address = addressRepo.getAllAddresss();
        return new ResponseEntity<List<Address>>(address,HttpStatus.FOUND);
    }

    @PostMapping("/addAddress")
    public void addAddress(@RequestBody Address address){
        addressRepo.addAddress(address);
    }

//---------------------------------------------------------------------------


    @GetMapping("/getMerchant/{m_Id}")
    public ResponseEntity<Merchant> getMerchantByMerchantId(@PathVariable("m_Id") int m_Id){
        Merchant merchant =  merchantRepo.getOne(m_Id);
           if(merchant!=null)
            return  new ResponseEntity<Merchant>(merchant,HttpStatus.FOUND);
            return new ResponseEntity<Merchant>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getMerchants")
    public ResponseEntity<List<Merchant>> getAllMerchants(){
        List<Merchant> merchants =  merchantRepo.findAll();
        if(merchants!=null)
            return  new ResponseEntity<List<Merchant>>(merchants,HttpStatus.FOUND);
        return new ResponseEntity<List<Merchant>>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addMerchant")
    public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant merchant){
           merchantRepo.save(merchant);
        return  new ResponseEntity<Merchant>(merchant,HttpStatus.CREATED);
    }

    @PostMapping("/updateMerchant/{m_Id}")
    public ResponseEntity<Merchant> updateMerchant(@PathVariable("m_Id")int m_Id,@RequestBody Merchant merchant){
        Merchant merchant1 = merchantRepo.save(merchant);
        return  new ResponseEntity<Merchant>(merchant1,HttpStatus.ACCEPTED);
    }

    @PostMapping("/deleteMerchant/{m_Id}")
    public ResponseEntity<Merchant> deleteMerchant(@PathVariable("m_Id")int m_Id){
        merchantRepo.deleteById(m_Id);
        return  new ResponseEntity<Merchant>(HttpStatus.OK);
    }
//-----------------------------------------------------------------------------------------
//Logger log = LogFactory.getLogger(this.getClass());
    @PostMapping("/user")
    public ResponseEntity<User> getUser(@RequestBody Login login){

        User user = loginRepo.getUser(login);
        if(user==null)
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<User>(user,HttpStatus.FOUND);
    }/*
    @Autowired
    RestTemplate restTemplate;*/

   /* @GetMapping("/hi")
    public ResponseEntity<Object> callApi() {
        Object obj = restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees", Object.class);
        return new ResponseEntity<Object>(obj, HttpStatus.FOUND);
    }*/

    @GetMapping("/rest/getMerchants")
    public ResponseEntity<List<Merchant>> getMerchants(){
        List<Merchant> merchants =  merchantRepo.findAll();
        if(merchants!=null)
            return  new ResponseEntity<List<Merchant>>(merchants,HttpStatus.FOUND);
        return new ResponseEntity<List<Merchant>>(HttpStatus.NOT_FOUND);
    }

    //get orders for merchantId
    @GetMapping("/getOrdersByMerchantId/{m_id}")
    public ResponseEntity<List<Order>> getOrdersByMerchant(@PathVariable("m_id")int m_id){
        List<Order> orders = orderRepo.getOrdersByMerchantId(m_id);
        if(orders!=null)
            return new ResponseEntity<List<Order>>(orders,HttpStatus.FOUND);
        return new ResponseEntity<List<Order>>(orders,HttpStatus.NOT_FOUND);
    }
    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);
    @GetMapping("/elk")
    public String helloWorld(){
        String response  = "welcome to ELK Stack"+new Date();
        LOG.info(response);
        return response;
    }

    @GetMapping("/exception")
    public String helloWorldException(){
        String response  = "";
        try{
            throw  new Exception("Exception has occured ....");
        }
        catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            LOG.error("Exception - " + stackTrace);
            response = stackTrace;
            //LOG.error(e+"");
        }
        LOG.error(response);
        return response;
    }
}


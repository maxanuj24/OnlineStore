package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import com.startup.OnlineStore.model.Item;

@Repository
@Transactional
public class OrderRepo {
    @Autowired
    EntityManager em;

    @Autowired
    UserRepo userRepo;
    @Autowired
    AddressRepo addressRepo;

    public void addOrder(Order order) {
        int userId = order.getUid();
        User user = userRepo.getUserById(userId);
        Address address = addressRepo.getAddress(order.getAddrid());
       // address.addOrder(order);
        List<Item> items = order.getItems();
            order.setItems(items);
        user.addOrder(order);
        order.setUser(user);
       // order.setAddress(address);
        em.persist(order);
    }
    public void addItemToOrder(Item item,int oid) {
        Order order = getOrder(oid);
        order.addItem(item);
        //  em.persist(order);
    }
    public List<Order> getAllOrders() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> rootEntry = cq.from(Order.class);
        CriteriaQuery<Order> all = cq.select(rootEntry);
        TypedQuery<Order> allQuery = em.createQuery(all);
        return allQuery.getResultList();

    }

    public Order getOrder(int orderId) {
        return em.find(Order.class,orderId);
    }

    public List<Order> getOrdersByMerchantId(int merchantId) {
        List<Order> allOrders = getAllOrders();
        List<Order> orders = new ArrayList<>();
        for(Order order:orders){
            if(order.getM_id()==merchantId){
                   orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> getOrdersByMerchantIdAndStatus(int merchantId,String status) {
        List<Order> allOrders = getOrdersByMerchantId(merchantId);
        List<Order> orders = new ArrayList<>();
        for(Order order:orders){
            if(order.getOrderStatus().equals(status)){
                orders.add(order);
            }
        }
        return orders;
    }
}

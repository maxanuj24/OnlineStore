package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import com.startup.OnlineStore.model.Item;

@Repository
@Transactional
public class OrderRepo {
    @Autowired
    EntityManager em;

    @Autowired
    UserRepo userRepo;

    public void addOrder(Order order) {
        int userId = order.getUid();
        User user = userRepo.getUserById(userId);

        user.addOrder(order);
        order.setUser(user);
        em.persist(order);
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
}

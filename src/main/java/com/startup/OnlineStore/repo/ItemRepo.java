package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemRepo{

    @Autowired
    EntityManager em;

    public Item getItem(Integer itemId) {
        return em.find(Item.class,itemId);
    }

    public List<Item> getAllItems() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> rootEntry = cq.from(Item.class);
        CriteriaQuery<Item> all = cq.select(rootEntry);
        TypedQuery<Item> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public void addItem(Item item) {
        ///String categoryName = item.getCategoryname();
        ///Category category = categoryRepo.getCategoryByName(categoryName);

        //category.addItems(item);
       // item.setCategory(category);
        em.persist(item);

    }
}

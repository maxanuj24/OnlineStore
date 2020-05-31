package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CategoryRepo {
    @Autowired
    EntityManager em;
    public Category getCategoryById(int categoryId) {
       return em.find(Category.class,categoryId);
    }

    public List<Category> getCategories() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> rootEntry = cq.from(Category.class);
        CriteriaQuery<Category> all = cq.select(rootEntry);
        TypedQuery<Category> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Category addCategory(Category category) {
        if(getCategoryById(category.getId())==null) {
            em.persist(category);
        }else{
            em.merge(category);
        }
        return category;
    }

    public Category getCategoryByName(String categoryName) {
        List<Category> categories = getCategories();
        for(Category category:categories){
            if(category.getName().equals(categoryName)){
                return category;
            }
        }
        return null;
    }
}

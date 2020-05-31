package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.User;
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
public class UserRepo {


    @Autowired
    EntityManager em;

    public User addUser(User user) {
        if (getUserById(user.getId()) == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        return user;
    }

    public List<User> getUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public User getUserById(int userId) {
        return em.find(User.class, userId);
    }

    public User getUserByName(String UserName) {
        List<User> categories = getUsers();
        for (User User : categories) {
            if (User.getName().equals(UserName)) {
                return User;
            }
        }
        return null;
    }
}

package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.Category;
import com.startup.OnlineStore.model.Address;
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
public class AddressRepo {

    @Autowired
    EntityManager em;

    @Autowired
    UserRepo userRepo;

    public Address getAddress(Integer addressId) {
        return em.find(Address.class,addressId);
    }

    public List<Address> getAllAddresss() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Address> cq = cb.createQuery(Address.class);
        Root<Address> rootEntry = cq.from(Address.class);
        CriteriaQuery<Address> all = cq.select(rootEntry);
        TypedQuery<Address> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public void addAddress(Address address) {
        int userId = address.getUid();
        User user = userRepo.getUserById(userId);
       //user.addAddress(address);
        address.setUser(user);
        em.persist(address);
    }
}

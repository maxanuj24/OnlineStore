package com.startup.OnlineStore.repo;

import com.startup.OnlineStore.model.Login;
import com.startup.OnlineStore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class LoginRepo {

    @Autowired
    EntityManager em;
    @Autowired
    UserRepo userRepo;
    public User getUserByUserName(String userName){
        Login login = em.find(Login.class,userName);

        if(login==null)
            return null;
        int uid = login.getUid();
        User user = userRepo.getUserById(uid);
        return user;
    }
    public User getUser(Login login){
        if(login==null)
            return null;
        int uid = login.getUid();
        User user = userRepo.getUserById(uid);
        return user;
    }
}

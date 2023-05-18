package com.example.kata312.dao;

import com.example.kata312.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        User someUser = entityManager.find(User.class, id);
        entityManager.remove(someUser);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByLogin(String login) {
        return entityManager.createQuery("select u from User u where u.login =: login", User.class)
                .setParameter("login", login).getSingleResult();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
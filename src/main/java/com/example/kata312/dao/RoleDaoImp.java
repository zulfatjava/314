package com.example.kata312.dao;

import com.example.kata312.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
@Transactional
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRole(String userRole) {
        return entityManager.createQuery("select r from Role r where r.name =: name", Role.class)
                .setParameter("name", userRole).getSingleResult();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
}
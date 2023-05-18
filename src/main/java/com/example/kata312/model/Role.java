package com.example.kata312.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }



    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
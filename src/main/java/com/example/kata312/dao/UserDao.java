package com.example.kata312.dao;



import com.example.kata312.model.User;

import java.util.List;

public interface UserDao  {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByLogin(String login);

    User getUserById(long id);
    }


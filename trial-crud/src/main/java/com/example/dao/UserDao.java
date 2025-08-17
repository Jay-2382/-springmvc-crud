package com.example.dao;

import com.example.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(int id);

    User get(int id);

    List<User> list();

    List<User> listSortedByName();

    List<User> listSortedByCountry();

    List<User> searchByName(String name);

    List<User> searchByCountry(String country);
}

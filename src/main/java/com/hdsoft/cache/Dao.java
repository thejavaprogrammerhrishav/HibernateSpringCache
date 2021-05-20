package com.hdsoft.cache;

import java.util.List;

public interface Dao {
    int save(Model model);

    List<Model> findAll();

    List<Model> findByName(String name);
    List<User> find();
    Model findByID(int id);

}

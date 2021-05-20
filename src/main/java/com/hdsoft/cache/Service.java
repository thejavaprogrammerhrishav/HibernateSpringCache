package com.hdsoft.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableCaching
public class Service{

    @Autowired
    private Dao dao;

    public int save(Model model) {
        try{
            return dao.save(model);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Cacheable(value = "ehcache", key = "")
    public List<Model> findAll() {
        try{
            return dao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<Model>();
    }

    @Cacheable("ehcache")
    public List<Model> findByName(String name) {
        try{
            return dao.findByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<Model>();
    }

    @Cacheable("ehcache")
    public Model findByID(int id) {
        try{
            return dao.findByID(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Cacheable("ehcache")
    public List<User> find() {
        try{
            return dao.find();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<User>();
    }
}

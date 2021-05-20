package com.hdsoft.cache;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Impl implements Dao{

    @Autowired
    private HibernateTemplate hibernateTemplate;



    @Transactional
    public int save(Model model) {
        return (Integer)hibernateTemplate.save(model);
    }

    @Transactional
    public List<Model> findAll() {
        System.out.println("Fetching All");
        return hibernateTemplate.loadAll(Model.class);
    }

    @Transactional
    public List<User> find() {
        System.out.println("Fetching Name");
        return (List<User>) hibernateTemplate.find(" select new com.hdsoft.cache.User(m.name,m.contact) from Model as m ");
    }

    @Transactional
    public List<Model> findByName(String name) {
        System.out.println("Fetching Name");
        return (List<Model>) hibernateTemplate.findByNamedParam("from Model where name like :name","name","%"+name+"%");
    }

    @Transactional
    public Model findByID(int id) {
        System.out.println("Fetching ID");
        return hibernateTemplate.get(Model.class,id);
    }
}

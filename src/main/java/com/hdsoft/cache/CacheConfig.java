package com.hdsoft.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


public class CacheConfig {

   /* @Bean
    public EhCacheManagerFactoryBean getCacheBean() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("/ehcache.xml"));
        bean.setShared(true);
        return bean;
    }

    @Bean(name = "cacheManager")
    public CacheManager getCacheManager() {
        return new EhCacheCacheManager(getCacheBean().getObject());
    }*/

}

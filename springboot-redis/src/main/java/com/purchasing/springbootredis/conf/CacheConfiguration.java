package com.purchasing.springbootredis.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
@Configuration
@EnableCaching//激活Cache
public class CacheConfiguration {

    /**
     * 声明一个CacheManager
     * @return
     */
    @Bean
    public CacheManager getCacheManager(){
        SimpleCacheManager manager = new SimpleCacheManager();
        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");
        ConcurrentMapCache personCache = new ConcurrentMapCache("persons");
        manager.setCaches(Arrays.asList(cache,personCache));
        return manager;
    }
}

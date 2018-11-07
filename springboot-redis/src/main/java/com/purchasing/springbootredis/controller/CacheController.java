package com.purchasing.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="15711366039@163.com">zhangwei</a>
 * @since 2018/11/7
 */
@RestController
@RequestMapping(value = "cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @PostMapping(value = "save")
    public Map<String,Object> save(@RequestParam String key,@RequestParam String value){

        Cache cache = cacheManager.getCache("cache-1");
        cache.put(key,value);
        Map<String,Object> result = new HashMap<>();
        result.put(key,value);
        return result;
    }
}

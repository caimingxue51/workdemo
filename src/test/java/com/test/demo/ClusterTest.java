package com.test.demo;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClusterTest {
    
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    
    ValueOperations<String, Object> stringRedis;
    
    @PostConstruct
    public void init(){
        stringRedis=redisTemplate.opsForValue();
    }
    
    
    @Test
    public void testString (){
        //stringRedis.
    }
}
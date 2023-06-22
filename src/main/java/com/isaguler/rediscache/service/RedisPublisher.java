package com.isaguler.rediscache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisPublisher {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisPublisher(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void pubCh1(String channel ,String message) {
        Long numOfClients = redisTemplate.convertAndSend(channel, message);
        log.info("numOfClients: " + numOfClients); // amount of subscribers
    }
}

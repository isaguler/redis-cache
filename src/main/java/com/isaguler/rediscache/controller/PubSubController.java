package com.isaguler.rediscache.controller;

import com.isaguler.rediscache.service.RedisPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class PubSubController {

    private final RedisPublisher redisPublisher;

    public PubSubController(RedisPublisher redisPublisher) {
        this.redisPublisher = redisPublisher;
    }

    @PostMapping("/pub")
    public ResponseEntity<Object> pubMessage(@RequestParam String channel, @RequestParam(value = "message") String message) {
        redisPublisher.pubCh1(channel, message);
        return ResponseEntity.ok().body("published!");
    }
}

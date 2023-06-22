package com.isaguler.rediscache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class RedisSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String patternString = new String(pattern, StandardCharsets.UTF_8);
        log.info("message patternString: " + patternString); // [channel/topic]

        log.info("message: " + message.toString());

        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("message body: " + body);

        String channel = new String(message.getChannel(), StandardCharsets.UTF_8);
        log.info("message channel: " + channel);

    }
}

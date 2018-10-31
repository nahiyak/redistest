package com.example.redis;

import com.example.redis.model.Peer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories(considerNestedRepositories = true, enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

//    @Bean
//    ApplicationListener<RedisKeyExpiredEvent<Peer>> eventListener() {
//        return event -> {
//            System.out.println(String.format("Received expire event for key=%s with value %s.",
//                    new String(event.getSource()), event.getValue()));
//        };
//    }
}

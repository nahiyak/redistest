package com.example.redis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash("room")
public class Room {
    @Id
    private String roomId;
    @Indexed
    private String creatorId;
    @Indexed
    private String playAppId;
    @Indexed
    private String delYn;
}

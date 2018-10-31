package com.example.redis.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Data
@ToString
@RedisHash("peer")
public class Peer {
    @Id
    private String peerId;
    @Indexed
    private String userId;
    @Indexed
    private String userType;
    @Indexed
    private String delYn;

    @TimeToLive
    private Long expiration;
}

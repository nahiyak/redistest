package com.example.redis.model;

import lombok.Data;
import lombok.Singular;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@Data
@RedisHash("room_peer")
public class RoomPeer {
    @Id
    private String roomPeerId;
    @Indexed
    private String roomId;
    @Reference
    private List<Peer> peers;

}

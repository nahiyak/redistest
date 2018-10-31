package com.example.redis.repository;

import com.example.redis.model.Peer;
import com.example.redis.model.RoomPeer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomPeerRepository extends CrudRepository<RoomPeer, String> {
    List<Peer> findRoomPeersByPeersWithin(Peer peer);
}

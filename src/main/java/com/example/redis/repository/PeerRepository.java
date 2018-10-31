package com.example.redis.repository;

import com.example.redis.model.Peer;
import org.springframework.data.repository.CrudRepository;

public interface PeerRepository extends CrudRepository<Peer, String> {

    Peer findPeerByUserIdAndUserType(String userId, String userType);
}

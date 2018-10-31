package com.example.redis.repository;

import com.example.redis.model.Peer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber {
    @Autowired
    private PeerRepository peerRepository;

    @EventListener
    public void event(RedisKeyExpiredEvent<Peer> event){
        System.out.println(new String(event.getSource()));
        System.out.println(((Peer)event.getValue()).getUserId());

    }

//    ApplicationListener<RedisKeyExpiredEvent<Peer>> eventListener() {
//        return event -> {
////            System.out.println(String.format("Received expire event for key=%s with value %s.",
////                    new String(event.getSource()), event.getValue()));
//
//
//            peerRepository.deleteById(((Peer)event.getValue()).getPeerId());
//        };
//    }
}

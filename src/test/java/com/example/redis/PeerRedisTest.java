package com.example.redis;

import ch.qos.logback.core.util.TimeUtil;
import com.example.redis.model.Peer;
import com.example.redis.model.Room;
import com.example.redis.model.RoomPeer;
import com.example.redis.repository.PeerRepository;
import com.example.redis.repository.RoomPeerRepository;
import com.example.redis.repository.RoomRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeerRedisTest {
    @Autowired
    private PeerRepository peerRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomPeerRepository roomPeerRepository;

    @Before
    public void tearUp() throws Exception {
        peerRepository.deleteAll();
        roomRepository.deleteAll();
        roomPeerRepository.deleteAll();

    }

    @Test
    public void test1() throws InterruptedException {
//        peerRepository.deleteById();
        peerRepository.findAll().forEach(System.out::println);
        String peerId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        String userType = "0";
        Peer peer = new Peer();
        peer.setPeerId(peerId);
        peer.setUserId(userId);
        peer.setUserType(userType);
        peer.setDelYn("N");
        peer.setExpiration(10L);

        String peerId2 = UUID.randomUUID().toString();
        String userId2 = UUID.randomUUID().toString();
        String userType2 = "0";
        Peer peer2 = new Peer();
        peer2.setPeerId(peerId2);
        peer2.setUserId(userId2);
        peer2.setUserType(userType2);
        peer2.setDelYn("N");
        peer2.setExpiration(10L);

        //when
        peerRepository.save(peer);
        peerRepository.save(peer2);


        peerRepository.findAll().forEach(System.out::println);
//        //then
//        Peer retPeer = peerRepository.findPeerByUserIdAndUserType(userId2, userType2);
//
//        System.out.println(retPeer);

        String roomId = UUID.randomUUID().toString();
        Room room = new Room();
        room.setRoomId(roomId);
        room.setCreatorId(userId);
        room.setDelYn("N");
        room.setPlayAppId("lin");

        roomRepository.save(room);


//        roomRepository.findAll().forEach(System.out::println);

        roomRepository.findRoomsByPlayAppIdAndDelYn("lin", "N").forEach(System.out::println);

//
        String roomPeerId = UUID.randomUUID().toString();
        RoomPeer roomPeer = new RoomPeer();
        roomPeer.setRoomPeerId(roomPeerId);
        roomPeer.setRoomId(roomId);
        roomPeer.setPeers(Arrays.asList(peer, peer2));


        roomPeerRepository.save(roomPeer);

        roomPeerRepository.findAll().forEach(System.out::println);
        //roomPeerRepository.save(roomPeer);

//        peerRepository.delete(peer);
////
////        roomPeerRepository.findAll().forEach(System.out::println);
////        RoomPeer roomPeer2 = new RoomPeer();
////        roomPeer2.setRoomPeerId(roomPeerId);
////        roomPeer2.setRoomId(roomId);
////        roomPeer2.setPeers(Arrays.asList(peer, peer2));
////
////        roomPeerRepository.save(roomPeer2);
////
////        roomPeerRepository.findAll().forEach(System.out::println);

//        peerRepository.delete(peer);
//
//        roomPeerRepository.findAll().forEach(System.out::println);

        TimeUnit.SECONDS.sleep(40);

    }
}

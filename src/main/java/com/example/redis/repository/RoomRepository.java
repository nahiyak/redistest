package com.example.redis.repository;

import com.example.redis.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, String> {

    List<Room> findRoomsByPlayAppIdAndDelYn(String playAppId, String delYn);

}

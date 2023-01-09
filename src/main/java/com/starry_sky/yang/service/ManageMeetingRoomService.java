package com.starry_sky.yang.service;

import com.starry_sky.yang.bean.Room;

import java.util.List;

public interface ManageMeetingRoomService {

    List<Room> lookMeetingRoom();
    void updateMeetingRoom(String start_time, String end_time, String address, int max_people, String room_id);
    void delMeetingRoom(String room_id);
}

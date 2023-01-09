package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.bean.Room;
import com.starry_sky.yang.dao.ManageMeetingRoomDao;
import com.starry_sky.yang.dao.impl.ManageMeetingRoomDaoImpl;
import com.starry_sky.yang.service.ManageMeetingRoomService;

import java.util.List;

public class ManageMeetingRoomServiceImpl implements ManageMeetingRoomService {

    private ManageMeetingRoomDao manageMeetingRoomDao = new ManageMeetingRoomDaoImpl();
    @Override
    public List<Room> lookMeetingRoom() {
        return manageMeetingRoomDao.selectMeetingRoom();
    }

    @Override
    public void updateMeetingRoom(String start_time, String end_time, String address, int max_people, String room_id) {
        manageMeetingRoomDao.updateMeetingRoom(start_time,end_time,address,max_people,room_id);
    }

    @Override
    public void delMeetingRoom(String room_id) {
        manageMeetingRoomDao.delMeetingRoom(room_id);
    }
}

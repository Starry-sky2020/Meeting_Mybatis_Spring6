package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.StaffAppointRoomDao;
import com.starry_sky.yang.dao.impl.StaffAppointRoomImpl;
import com.starry_sky.yang.service.StaffAppointRoomService;

public class StaffAppointRoomServiceImpl implements StaffAppointRoomService {

    private StaffAppointRoomDao staffAppointRoomDao = new StaffAppointRoomImpl();
    @Override
    public void AppointRoom(String room, String start_time, String end_time, int people, String department_id, String staff_id) {
        staffAppointRoomDao.insertAppointRoom(room,start_time,end_time,people,department_id,staff_id);
    }
}

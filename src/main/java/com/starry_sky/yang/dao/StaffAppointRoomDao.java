package com.starry_sky.yang.dao;

public interface StaffAppointRoomDao {

    void insertAppointRoom(String room, String start_time, String end_time, int people, String department_id, String staff_id);
}

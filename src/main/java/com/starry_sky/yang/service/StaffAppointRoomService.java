package com.starry_sky.yang.service;

public interface StaffAppointRoomService {

    void AppointRoom(String room, String start_time, String end_time, int people, String department_id, String staff_id);
}

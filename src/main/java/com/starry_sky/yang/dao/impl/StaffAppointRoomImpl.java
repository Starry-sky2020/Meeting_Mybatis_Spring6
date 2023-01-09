package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.dao.StaffAppointRoomDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.swing.plaf.SeparatorUI;
import java.util.HashMap;
import java.util.Map;

public class StaffAppointRoomImpl implements StaffAppointRoomDao {
    @Override
    public void insertAppointRoom(String room, String start_time, String end_time, int people, String department_id, String staff_id) {
        Map<String,Object> map = new HashMap<>();
        SqlSession sqlSession = SqlSessionUtil.openSession();

        map.put("room", room);
        map.put("start_time", start_time);
        map.put("end_time", end_time);
        map.put("people",people);
        map.put("department_id", department_id);
        map.put("staff_id", staff_id);

        sqlSession.insert("insertAppointRoom", map);

        sqlSession.close();
    }
}

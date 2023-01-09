package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.bean.Room;
import com.starry_sky.yang.dao.ManageMeetingRoomDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageMeetingRoomDaoImpl implements ManageMeetingRoomDao {
    @Override
    public List<Room> selectMeetingRoom() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Room> roomList = new ArrayList<>();
        roomList = sqlSession.selectList("selectMeetingRoom");

        return roomList;
    }

    @Override
    public void updateMeetingRoom(String start_time, String end_time, String address, int max_people, String room_id) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map = new HashMap<>();
        map.put("start_time",start_time);
        map.put("end_time",end_time);
        map.put("address",address);
        map.put("max_people",max_people);
        map.put("room_id",room_id);

        sqlSession.update("updateMeetingRoom",map);
        sqlSession.close();
    }

    @Override
    public void delMeetingRoom(String room_id) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map = new HashMap<>();

        map.put("room_id",room_id);
        sqlSession.delete(room_id);
        sqlSession.close();
    }
}

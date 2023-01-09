package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.bean.Appoint;
import com.starry_sky.yang.dao.ManageDelAppointDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageDelAppointDaoImpl implements ManageDelAppointDao {

    @Override
    public void delAppoint(String record_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("record_id", record_id);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.delete("delMeetingRecord", map);

        sqlSession.close();
    }

    @Override
    public List<Appoint> selectAppoint() {
        List<Appoint> appointList = new ArrayList<>();
        SqlSession sqlSession = SqlSessionUtil.openSession();

        appointList = sqlSession.selectList("selectAppoint");
        sqlSession.close();

        return appointList;
    }
}

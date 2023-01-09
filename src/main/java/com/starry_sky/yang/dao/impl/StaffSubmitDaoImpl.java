package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.dao.StaffSubmitDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class StaffSubmitDaoImpl implements StaffSubmitDao {
    @Override
    public void InsertStaffMessage(String username, String password, int age, String address) {
        Map<String,Object> map = new HashMap<>();
        map.put("staff_name",username);
        map.put("staff_phone",password);
        map.put("staff_age",age);
        map.put("staff_address",address);

        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.insert("insertStaffMessage",map);
    }
}

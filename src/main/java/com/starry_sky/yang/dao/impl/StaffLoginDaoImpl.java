package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.bean.Staff;
import com.starry_sky.yang.dao.StaffLoginDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaffLoginDaoImpl implements StaffLoginDao {
    @Override
    public List<Map<String,Object>> selectAllStaff() {

        List<Map<String,Object>> staffList = new ArrayList<>();
        SqlSession sqlSession = SqlSessionUtil.openSession();
        staffList = sqlSession.selectList("selectAllStaff");

        return staffList;
    }
}

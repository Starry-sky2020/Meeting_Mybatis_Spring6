package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.bean.Staff;
import com.starry_sky.yang.dao.ManageStaffRecordDao;
import com.starry_sky.yang.servlet.SubmitServlet;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageStaffRecordDaoImpl implements ManageStaffRecordDao {
    @Override
    public List<Staff> selectStaffRecord() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Staff> staffList = new ArrayList<>();

        staffList = sqlSession.selectList("selectStaffRecord");
        sqlSession.close();
        return staffList;
    }

    @Override
    public void updateStaffRecord(String staff_name, int staff_age, String staff_address, String staff_phone, String staff_id) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map = new HashMap<>();
        map.put("staff_name",staff_name);
        map.put("staff_age", staff_age);
        map.put("staff_address",staff_address);
        map.put("staff_phone",staff_phone);
        map.put("staff_id",staff_id);

        sqlSession.update("updateStaffRecord", map);
        sqlSession.close();
    }

    @Override
    public void delStaffRecord(String staff_id) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map = new HashMap<>();
        map.put("staff_id",staff_id);

        sqlSession.delete("delStaffRecord",map);
        sqlSession.close();
    }
}

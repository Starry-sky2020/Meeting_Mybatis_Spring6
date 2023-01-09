package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.dao.ManageLoginDao;
import com.starry_sky.yang.servlet.SubmitServlet;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManageLoginDaoImpl implements ManageLoginDao {
    @Override
    public List<Map<String, Object>> selectManager() {

        List<Map<String,Object>> mapList = new ArrayList<>();
        SqlSession sqlSession = SqlSessionUtil.openSession();
        mapList = sqlSession.selectList("selectManager");

        return mapList;
    }
}

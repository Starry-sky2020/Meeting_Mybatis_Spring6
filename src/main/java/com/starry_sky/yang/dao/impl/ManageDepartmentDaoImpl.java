package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.bean.Dept;
import com.starry_sky.yang.dao.ManageDepartmentDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageDepartmentDaoImpl implements ManageDepartmentDao {
    @Override
    public List<Dept> selectDepartment() {
        List<Dept> deptList = new ArrayList<>();
        SqlSession sqlSession = SqlSessionUtil.openSession();

        deptList = sqlSession.selectList("selectDepartment");

        return deptList;
    }

    @Override
    public void updateDepartment(String dep_name, int person_num, int manage_id, String manage_name,String department_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("dep_name", dep_name);
        map.put("person_num", person_num);
        map.put("manage_id",manage_id);
        map.put("manage_name",manage_name);
        map.put("department_id",department_id);

        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.update("updateDepartment",map);

        sqlSession.close();
    }

    @Override
    public void delDepartment(String department_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("department_id",department_id);

        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.delete("delDepartment",map);

        sqlSession.close();
    }
}

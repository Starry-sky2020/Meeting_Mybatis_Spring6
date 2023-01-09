package com.starry_sky.yang.test;

import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void testSelectAllStaff(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        mapList = sqlSession.selectList("selectAllStaff");
        for (Map<String, Object> map : mapList) {
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.print(m.getKey() + "   33 ");
                System.out.println(m.getValue());
            }
        }
    }

    @Test
    public void testInsertStaffMessage(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("staff_name", "小明");
        map.put("staff_phone", "12345678");
        map.put("age",20);
        map.put("address","北京");

        sqlSession.insert("insertStaffMessage",map);
        sqlSession.close();
    }

    @Test
    public void testAppointRoom(){

    }
}

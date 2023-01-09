package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.ManageLoginDao;
import com.starry_sky.yang.dao.impl.ManageLoginDaoImpl;
import com.starry_sky.yang.service.ManageLoginService;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManageLoginServiceImpl implements ManageLoginService {

    private ManageLoginDao manageLoginDao = new ManageLoginDaoImpl();

    @Override
    public int ManageLogin(String username, String password) {
        List<Map<String, Object>> mapList = new ArrayList<>();

        mapList = manageLoginDao.selectManager();

        for (Map<String, Object> map:mapList){
            if (map.get("manager_name").equals(username)){
                if (map.get("manager_id").equals(password)){
                    return 1;
                }return 2;
            }return 3;
        }
        return 0;
    }
}

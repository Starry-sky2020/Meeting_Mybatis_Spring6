package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.StaffLoginDao;
import com.starry_sky.yang.dao.impl.StaffLoginDaoImpl;
import com.starry_sky.yang.service.StaffLoginService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StaffLoginServiceImpl implements StaffLoginService {

    private StaffLoginDao staffLoginDao = new StaffLoginDaoImpl();

    @Override
    public int staffLogin(String username, String password) {
        List<Map<String,Object>> staffList = new ArrayList<>();

        staffList = staffLoginDao.selectAllStaff();

        for (Map<String, Object> map : staffList) {
            if (map.get("staff_name").equals(username)){
                System.out.println(map.get("staff_name"));
                System.out.println(map.get("staff_phone"));
                System.out.println(password);
                if (String.valueOf(map.get("staff_phone")).equals(password)){
                    System.out.println(map.get("staff_phone"));
                    return 1;
                } else return 2;
            } else return 3;
        }

        return 0;
    }
}

package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.StaffSubmitDao;
import com.starry_sky.yang.dao.impl.StaffSubmitDaoImpl;
import com.starry_sky.yang.service.StaffSubmitService;

public class StaffSubmitServiceImpl implements StaffSubmitService {

    private StaffSubmitDao staffSubmitDao = new StaffSubmitDaoImpl();
    @Override
    public void insertStaffMessage(String username, String password, int age, String address) {
        staffSubmitDao.InsertStaffMessage(username,password,age,address);
    }
}

package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.bean.Appoint;
import com.starry_sky.yang.dao.ManageDelAppointDao;
import com.starry_sky.yang.dao.StaffRecordDao;
import com.starry_sky.yang.dao.impl.ManageDelAppointDaoImpl;
import com.starry_sky.yang.dao.impl.StaffRecordDaoImpl;
import com.starry_sky.yang.service.ManageDelAppointService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageDelAppointServiceImpl implements ManageDelAppointService {
    private ManageDelAppointDao manageDelAppointDao = new ManageDelAppointDaoImpl();
    @Override
    public List<Appoint> lookAppoint() {
        List<Appoint> appointList = new ArrayList<>();
        appointList = manageDelAppointDao.selectAppoint();

        return appointList;
    }

    @Override
    public void delAppoint(String record_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("record_id",record_id);
        manageDelAppointDao.delAppoint(record_id);
    }
}

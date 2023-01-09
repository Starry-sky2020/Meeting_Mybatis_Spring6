package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.bean.Staff;
import com.starry_sky.yang.dao.ManageStaffRecordDao;
import com.starry_sky.yang.dao.impl.ManageStaffRecordDaoImpl;
import com.starry_sky.yang.service.ManageStaffRecordService;

import java.util.List;

public class ManageStaffRecordServiceImpl implements ManageStaffRecordService {

    private ManageStaffRecordDao manageStaffRecordDao = new ManageStaffRecordDaoImpl();
    @Override
    public List<Staff> lookStaffRecord() {
        return manageStaffRecordDao.selectStaffRecord();
    }

    @Override
    public void updateStaffRecord(String staff_name, int staff_age, String staff_address, String staff_phone, String staff_id) {
        manageStaffRecordDao.updateStaffRecord(staff_name,staff_age,staff_address,staff_phone,staff_id);
    }

    @Override
    public void delStaffRecord(String record_id) {
        manageStaffRecordDao.delStaffRecord(record_id);
    }
}

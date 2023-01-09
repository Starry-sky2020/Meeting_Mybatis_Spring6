package com.starry_sky.yang.dao;

import com.starry_sky.yang.bean.Staff;

import java.util.List;

public interface ManageStaffRecordDao {

    List<Staff> selectStaffRecord();
    void updateStaffRecord(String staff_name, int staff_age, String staff_address, String phone, String staff_id);
    void delStaffRecord(String staff_id);
}

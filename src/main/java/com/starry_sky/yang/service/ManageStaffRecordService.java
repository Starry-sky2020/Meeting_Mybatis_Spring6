package com.starry_sky.yang.service;

import com.starry_sky.yang.bean.Staff;

import java.util.List;

public interface ManageStaffRecordService {

    List<Staff> lookStaffRecord();
    void updateStaffRecord(String staff_name, int staff_age, String staff_address, String staff_phone, String staff_id);
    void delStaffRecord(String record_id);
}

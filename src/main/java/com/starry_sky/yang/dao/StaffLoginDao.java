package com.starry_sky.yang.dao;

import com.starry_sky.yang.bean.Staff;

import java.util.List;
import java.util.Map;

public interface StaffLoginDao {

    List<Map<String, Object>> selectAllStaff();
}

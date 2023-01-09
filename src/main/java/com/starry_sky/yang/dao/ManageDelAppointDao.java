package com.starry_sky.yang.dao;

import com.starry_sky.yang.bean.Appoint;

import java.util.List;

public interface ManageDelAppointDao {

    void delAppoint(String record_id);

    List<Appoint> selectAppoint();
}

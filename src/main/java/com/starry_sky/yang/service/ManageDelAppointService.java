package com.starry_sky.yang.service;

import com.starry_sky.yang.bean.Appoint;

import java.util.List;

public interface ManageDelAppointService {

    List<Appoint> lookAppoint();
    void delAppoint(String record_id);
}

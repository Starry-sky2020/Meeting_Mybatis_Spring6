package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.StaffRecordDao;
import com.starry_sky.yang.dao.impl.StaffRecordDaoImpl;
import com.starry_sky.yang.service.StaffRecordService;


import java.util.ArrayList;
import java.util.List;

public class StaffRecordServiceImpl implements StaffRecordService {
    private StaffRecordDao staffRecordDao = new StaffRecordDaoImpl();
    @Override
    public List<Record> selectAllMeetingRecord() {
        List<Record> recordList = new ArrayList<>();
        recordList = staffRecordDao.selectAllMeetingRecord();
        return recordList;
    }
}

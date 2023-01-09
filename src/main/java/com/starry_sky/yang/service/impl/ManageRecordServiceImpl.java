package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.ManageRecordDao;
import com.starry_sky.yang.dao.impl.ManageRecordDaoImpl;
import com.starry_sky.yang.service.ManageRecordService;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class ManageRecordServiceImpl implements ManageRecordService {

    private ManageRecordDao manageRecordDao = new ManageRecordDaoImpl();
    @Override
    public List<Record> lookRecord() {
        return manageRecordDao.selectRecord();
    }

    @Override
    public void delRecord(String record_id) {
        manageRecordDao.delRecord(record_id);
    }
}

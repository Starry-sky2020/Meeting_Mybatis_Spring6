package com.starry_sky.yang.dao;

import java.util.List;

public interface ManageRecordDao {

    List<Record> selectRecord();
    void delRecord(String record_id);
}

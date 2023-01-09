package com.starry_sky.yang.service;

import java.util.List;

public interface ManageRecordService {

    List<Record> lookRecord();
    void delRecord(String record_id);
}

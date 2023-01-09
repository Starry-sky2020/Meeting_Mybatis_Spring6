package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.dao.ManageRecordDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageRecordDaoImpl implements ManageRecordDao {
    @Override
    public List<Record> selectRecord() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Record> recordList = new ArrayList<>();
        recordList = sqlSession.selectList("selectAllMeetingRecord");

        sqlSession.close();
        return recordList;
    }

    @Override
    public void delRecord(String record_id) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map = new HashMap<>();
        map.put("record_id", record_id);

        sqlSession.delete("record_id",map);
        sqlSession.close();
    }
}

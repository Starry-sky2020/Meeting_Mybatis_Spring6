package com.starry_sky.yang.dao.impl;

import com.starry_sky.yang.dao.StaffRecordDao;
import com.starry_sky.yang.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class StaffRecordDaoImpl implements StaffRecordDao {
    @Override
    public List<Record> selectAllMeetingRecord() {
        List<Record> recordList = new ArrayList<>();
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.selectList("selectAllMeetingRecord", recordList);
        sqlSession.close();
        return recordList;
    }
}

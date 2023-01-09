package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.bean.Dept;
import com.starry_sky.yang.dao.ManageDepartmentDao;
import com.starry_sky.yang.dao.impl.ManageDepartmentDaoImpl;
import com.starry_sky.yang.service.ManageDepartmentService;

import java.util.ArrayList;
import java.util.List;

public class ManageDepartmentServiceImpl implements ManageDepartmentService {

    private ManageDepartmentDao manageDepartmentDao = new ManageDepartmentDaoImpl();

    @Override
    public List<Dept> lookDept() {
        List<Dept> deptList = new ArrayList<>();
        deptList = manageDepartmentDao.selectDepartment();
        return deptList;
    }

    @Override
    public void updateDepartment(String dep_name, int person_num, int manage_id, String manage_name,String department_id) {
        manageDepartmentDao.updateDepartment(dep_name,person_num,manage_id,manage_name,department_id);
    }


    @Override
    public void delDepartment(String department_id) {
        manageDepartmentDao.delDepartment(department_id);
    }
}

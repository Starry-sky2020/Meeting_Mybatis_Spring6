package com.starry_sky.yang.service;

import com.starry_sky.yang.bean.Dept;

import java.util.List;

public interface ManageDepartmentService {

    List<Dept> lookDept();
    void updateDepartment(String dep_name,int person_num,int manage_id,String manage_name,String department_id);
    void delDepartment(String department_id);
}

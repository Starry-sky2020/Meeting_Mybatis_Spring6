package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Staff;
import com.starry_sky.yang.service.ManageStaffRecordService;
import com.starry_sky.yang.service.impl.ManageStaffRecordServiceImpl;
import com.starry_sky.yang.util.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/ManageStaff","/updateStaff","/delStaff"})
public class ManageStaffServlet extends HttpServlet {

    private ManageStaffRecordService manageStaffRecordService = new ManageStaffRecordServiceImpl();
    private void delStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String staff_id = request.getParameter("staff_id");
        manageStaffRecordService.delStaffRecord(staff_id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageStaff");
        requestDispatcher.forward(request,response);
    }

    public void updateStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String staff_id = request.getParameter("staff_id");
        String staff_name = request.getParameter("staff_name");
        String staff_age = request.getParameter("staff_age");
        String staff_address = request.getParameter("staff_address");
        String staff_phone = request.getParameter("staff_phone");

        manageStaffRecordService.updateStaffRecord(staff_name,Integer.valueOf(staff_age),staff_address,staff_phone,staff_id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageStaff");
        requestDispatcher.forward(request,response);
    }

    public void manageStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Staff> staffList = new ArrayList<>();
        staffList = manageStaffRecordService.lookStaffRecord();
        request.setAttribute("staffList",staffList);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageStaff.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (servletPath.equals("/delStaff")){
            delStaff(request,response);
        } else if (servletPath.equals("/updateStaff")) {
            updateStaff(request,response);
        } else if (servletPath.equals("/ManageStaff")){
            manageStaff(request,response);
        }

    }
}

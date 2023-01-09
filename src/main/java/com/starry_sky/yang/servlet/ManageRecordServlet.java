package com.starry_sky.yang.servlet;


import com.starry_sky.yang.service.ManageRecordService;
import com.starry_sky.yang.service.impl.ManageRecordServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/ManageRecord", "/DelRecord"})
public class ManageRecordServlet extends HttpServlet {

    private ManageRecordService manageRecordService = new ManageRecordServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.equals("/ManageRecord")) {
            ManageRecord(request, response);
        } else if (servletPath.equals("/DelRecord")) {
            DelRecord(request, response);
        }

    }

    public void ManageRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Record> recordList = new ArrayList<>();
        recordList = manageRecordService.lookRecord();
        System.out.println(recordList);
        request.setAttribute("recordList",recordList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRecord.jsp");
        requestDispatcher.forward(request,response);
    }

    public void DelRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String record_id = request.getParameter("record_id");
        manageRecordService.delRecord(record_id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRecord");
        requestDispatcher.forward(request,response);
    }
}

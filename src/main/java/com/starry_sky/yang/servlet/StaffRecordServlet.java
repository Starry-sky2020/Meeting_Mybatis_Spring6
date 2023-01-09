package com.starry_sky.yang.servlet;


import com.starry_sky.yang.service.StaffRecordService;
import com.starry_sky.yang.service.impl.StaffRecordServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/record")
public class StaffRecordServlet extends HttpServlet {

    private StaffRecordService staffRecordService = new StaffRecordServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Record> list = new ArrayList<>();
        list = staffRecordService.selectAllMeetingRecord();
        request.setAttribute("list", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/record.jsp");
        dispatcher.forward(request, response);
    }
}

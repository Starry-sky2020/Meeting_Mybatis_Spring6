package com.starry_sky.yang.servlet;

import com.starry_sky.yang.service.StaffAppointRoomService;
import com.starry_sky.yang.service.impl.StaffAppointRoomServiceImpl;
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
import java.sql.SQLException;


@WebServlet("/appoint")
public class AppointServlet extends HttpServlet {

    private StaffAppointRoomService staffAppointRoomService = new StaffAppointRoomServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String room = request.getParameter("room");
        String start_time =  request.getParameter("start_time");
        String end_time =  request.getParameter("end_time");
        String people = request.getParameter("people");
        String department_id = request.getParameter("department_id");
        String staff_id = (String) request.getServletContext().getAttribute("staff_id");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int cnt = 0;
        staffAppointRoomService.AppointRoom(room,start_time,end_time,Integer.valueOf(people),department_id,staff_id);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/Appoint.jsp");
        dispatcher.forward(request, response);
    }
}

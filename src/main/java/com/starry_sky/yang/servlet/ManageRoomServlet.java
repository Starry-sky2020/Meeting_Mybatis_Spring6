package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Room;
import com.starry_sky.yang.service.ManageMeetingRoomService;
import com.starry_sky.yang.service.impl.ManageMeetingRoomServiceImpl;
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

@WebServlet({"/ManageRoom", "/UpdateManageRoom", "/DelManageRoom"})
public class ManageRoomServlet extends HttpServlet {

    private ManageMeetingRoomService manageMeetingRoomService = new ManageMeetingRoomServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.equals("/ManageRoom")){
            ManageRoom(request,response);
        } else if (servletPath.equals("/UpdateManageRoom")) {
            UpdateManageRoom(request,response);
        } else if (servletPath.equals("/DelManageRoom")) {
            DelManageRoom(request,response);
        }
    }

    public void ManageRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Room> roomList = new ArrayList<>();
        roomList = manageMeetingRoomService.lookMeetingRoom();

        request.setAttribute("roomList",roomList);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRoom.jsp");
        requestDispatcher.forward(request, response);
    }

    public void UpdateManageRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String address = request.getParameter("address");
        String max_people = request.getParameter("max_people");
        String room_id = request.getParameter("room_id");

        manageMeetingRoomService.updateMeetingRoom(start_time,end_time,address,Integer.valueOf(max_people),room_id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRoom");
        requestDispatcher.forward(request, response);
    }

    public void DelManageRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String room_id = request.getParameter("room_id");
        manageMeetingRoomService.delMeetingRoom(room_id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageRoom");
        requestDispatcher.forward(request, response);
    }
}
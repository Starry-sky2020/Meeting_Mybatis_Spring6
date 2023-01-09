package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Appoint;
import com.starry_sky.yang.service.ManageDelAppointService;
import com.starry_sky.yang.service.impl.ManageDelAppointServiceImpl;
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

@WebServlet({"/lookAppoint", "/delAppoint"})
public class DelAppointServlet extends HttpServlet {
    private ManageDelAppointService manageDelAppointService = new ManageDelAppointServiceImpl();
    public void lookAppoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Appoint> appointList = new ArrayList<>();
            appointList = manageDelAppointService.lookAppoint();
            request.setAttribute("appointList",appointList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/delAppoint.jsp");
            requestDispatcher.forward(request,response);

    }

    public void delAppoint( HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String appoint_id = request.getParameter("delAppoint_id");
        manageDelAppointService.delAppoint(appoint_id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/lookAppoint");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.equals("/lookAppoint")){
            lookAppoint(request,response);
        } else if (servletPath.equals("/delAppoint")){
            try {
                delAppoint(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
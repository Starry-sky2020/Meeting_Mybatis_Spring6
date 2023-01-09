package com.starry_sky.yang.servlet;

import com.starry_sky.yang.service.StaffSubmitService;
import com.starry_sky.yang.service.impl.StaffSubmitServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

    private StaffSubmitService staffSubmitService = new StaffSubmitServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        staffSubmitService.insertStaffMessage(username,password,Integer.valueOf(age),address);

        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }
}
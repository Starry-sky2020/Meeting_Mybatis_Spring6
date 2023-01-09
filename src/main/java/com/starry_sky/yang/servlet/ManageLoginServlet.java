package com.starry_sky.yang.servlet;

import com.starry_sky.yang.service.ManageLoginService;
import com.starry_sky.yang.service.impl.ManageLoginServiceImpl;
import com.starry_sky.yang.util.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/managerLogin")
public class ManageLoginServlet extends HttpServlet {

    private ManageLoginService manageLoginService = new ManageLoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String password = request.getParameter("password");
        String username = request.getParameter("username");

        int cnt = manageLoginService.ManageLogin(username,password);

        if (cnt == 1) {
            HttpSession session = request.getSession(false);
            session.setAttribute("manager_name",username);

            request.setAttribute("errorLogin",1);
            response.sendRedirect(request.getContextPath()+"/ManagerWelcome.jsp");
        } else if (cnt == 2) {
            request.setAttribute("errorLogin",2);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
            requestDispatcher.forward(request,response);
        } else if (cnt == 3) {
            request.setAttribute("errorLogin",3);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}

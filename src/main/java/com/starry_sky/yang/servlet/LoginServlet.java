package com.starry_sky.yang.servlet;

import com.starry_sky.yang.service.StaffLoginService;
import com.starry_sky.yang.service.impl.StaffLoginServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private StaffLoginService staffLoginService = new StaffLoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

       int res = staffLoginService.staffLogin(username,password);

       if (res == 1) {
           HttpSession session = request.getSession(false);
           session.setAttribute("staff_name",username);
           request.setAttribute("errorLogin",1);
           request.getServletContext().setAttribute("staff_id",password);
           response.sendRedirect(request.getContextPath()+"/welcom.jsp");
       } else if (res == 2) {
           request.setAttribute("errorLogin",2);
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
           requestDispatcher.forward(request,response);
       } else if (res == 3) {
           request.setAttribute("errorLogin",3);
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManagerLogin.jsp");
           requestDispatcher.forward(request,response);
       }
    }
}
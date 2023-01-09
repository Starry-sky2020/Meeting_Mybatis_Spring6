package com.starry_sky.yang.servlet;

import com.starry_sky.yang.bean.Dept;
import com.starry_sky.yang.dao.ManageDepartmentDao;
import com.starry_sky.yang.dao.impl.ManageDepartmentDaoImpl;
import com.starry_sky.yang.service.ManageDepartmentService;
import com.starry_sky.yang.service.impl.ManageDepartmentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/ManageDept","/UpdateDept","/DelDept"})
public class ManageDeptServlet extends HttpServlet {

    private ManageDepartmentService manageDepartmentService = new ManageDepartmentServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();

        if (servletPath.equals("/ManageDept")){
            ManageDept(request,response);
        } else if (servletPath.equals("/UpdateDept")) {
            UpdateDept(request,response);
        } else if (servletPath.equals("/DelDept")) {
            DelDept(request,response);
        }
    }

    public void ManageDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Dept> deptList = new ArrayList<>();
        deptList = manageDepartmentService.lookDept();
        request.setAttribute("deptList",deptList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageDept.jsp");
        requestDispatcher.forward(request,response);
    }

    public void UpdateDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dep_name = request.getParameter("dep_name");
        String person_num = request.getParameter("person_num");
        String manage_id = request.getParameter("manage_id");
        String manage_name = request.getParameter("manage_name");
        String id = request.getParameter("id");

        manageDepartmentService.updateDepartment(dep_name,Integer.valueOf(person_num),Integer.valueOf(manage_id),manage_name,id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageDept");
        requestDispatcher.forward(request,response);
    }

    public void DelDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        manageDepartmentService.delDepartment(id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ManageDept");
        requestDispatcher.forward(request,response);
    }
}

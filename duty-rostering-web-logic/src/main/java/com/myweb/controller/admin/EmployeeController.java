package com.myweb.controller.admin;


import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.command.EmployeeCommand;
import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.service.EmployeeService;
import com.myweb.core.service.impl.EmployeeServiceImpl;
import com.myweb.core.web.common.WebConstant;
import com.myweb.core.web.utils.RequestUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-employee-list.html")
public class EmployeeController extends HttpServlet {
	private EmployeeService empService = new EmployeeServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		EmployeeCommand command = new EmployeeCommand();
    		List<EmployeeDTO> empDTOS = new ArrayList<EmployeeDTO>();
    		command.setMaxPageItems(15);
    		RequestUtil.initSearchBean(request, command);
    		Object[] objects = empService.findEmployeeByProperties(null, null, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
    		command.setListResult((List<EmployeeDTO>) objects[1]);
            command.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
    		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/employee/list.jsp");
    		rd.forward(request, response);
    		
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
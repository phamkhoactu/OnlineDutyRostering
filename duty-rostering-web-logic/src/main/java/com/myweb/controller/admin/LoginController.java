package com.myweb.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.myweb.command.EmployeeCommand;
import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.service.EmployeeService;
import com.myweb.core.service.impl.EmployeeServiceImpl;
import com.myweb.core.web.common.WebConstant;
import com.myweb.core.web.utils.FormUtil;

import java.io.IOException;

/**
 * Created by Admin on 8/7/2017.
 */
@WebServlet("/login.html")
public class LoginController extends HttpServlet {
	private final Logger log = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("check");
		EmployeeCommand command = FormUtil.populate(EmployeeCommand.class, request);
		EmployeeDTO pojo = command.getPojo();
		System.out.println(pojo.getEmpId());
		EmployeeService empService = new EmployeeServiceImpl();

		try {
			if (empService.isEmployeeExist(pojo) != null) {
				if (empService.checkEmployeeIsAdmin(pojo) != null) {
					if (empService.checkEmployeeIsAdmin(pojo).isAdmin() == WebConstant.ROLE_ADMIN) {
						response.sendRedirect("admin-home.html");
					} else if (empService.checkEmployeeIsAdmin(pojo).isAdmin() == WebConstant.ROLE_USER) {
						response.sendRedirect("list.html");
					}
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
			request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Tên hoặc mật khẩu sai");
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response);
		}

	}
}
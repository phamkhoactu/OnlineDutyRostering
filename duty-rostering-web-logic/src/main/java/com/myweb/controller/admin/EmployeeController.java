package com.myweb.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.myweb.command.EmployeeCommand;
import com.myweb.core.common.constant.CoreConstant;
import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.service.EmployeeService;
import com.myweb.core.service.impl.EmployeeServiceImpl;
import com.myweb.core.web.common.WebConstant;
import com.myweb.core.web.utils.FormUtil;
import com.myweb.core.web.utils.RequestUtil;
import com.myweb.core.web.utils.WebCommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = { "/admin-employee-list.html", "/ajax-admin-employee-edit.html" })
public class EmployeeController extends HttpServlet {
	private EmployeeService empService = new EmployeeServiceImpl();
	private EmployeeService empService2 = new EmployeeServiceImpl();
	private final Logger log = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
		EmployeeCommand command = FormUtil.populate(EmployeeCommand.class, request);
		EmployeeDTO pojo = command.getPojo();
		if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
			Map<String, Object> mapProperty = new HashMap<String, Object>();
			command.setMaxPageItems(15);
			RequestUtil.initSearchBean(request, command);
			Object[] objects = empService.findEmployeeByProperties(mapProperty, command.getSortExpression(),
					command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
			command.setListResult((List<EmployeeDTO>) objects[1]);
			// command.setLastInsertedId((List<EmployeeDTO>) objects[1].);

			command.setTotalItems(Integer.parseInt(objects[0].toString()));
			if (command.getCrudaction() != null) {
				if (command.getCrudaction().equals(WebConstant.REDIRECT_DELETE)) {
					List<Short> ids = new ArrayList<Short>();
					
					for (String item : command.getCheckList()) {
						ids.add(Short.parseShort(item));
					}
					Integer result = empService.delete(ids);

					if (result != ids.size()) {
						request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
					} 
				}

				Map<String, String> mapMessage = buidMapRedirectMessage(bundle);
				WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);

			}
			request.setAttribute(WebConstant.LIST_ITEMS, command);

			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/employee/list.jsp");
			rd.forward(request, response);
		} else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
			if (pojo != null && pojo.getEmpId() != 0) {
				command.setPojo(empService.findById(pojo.getEmpId()));
			}

			command.setLastInsertedId(getLastInsertId());
			System.out.println("Command" + command.getLastInsertedId());
			request.setAttribute(WebConstant.FORM_ITEM, command);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/employee/edit.jsp");
			rd.forward(request, response);
		}

	}

	private short getLastInsertId() {
		Map<String, Object> mapProperty = new HashMap<String, Object>();
		Object[] objects2 = empService2.findEmployeeByProperties(mapProperty, "EMP_ID", CoreConstant.SORT_ASC, null,
				null);
		List<EmployeeDTO> list = (List<EmployeeDTO>) objects2[1];
		EmployeeDTO empDto = list.get(list.size() - 1);
		return empDto.getEmpId();
	}

	private Map<String, String> buidMapRedirectMessage(ResourceBundle bundle) {
		Map<String, String> mapMessage = new HashMap<String, String>();
		mapMessage.put(WebConstant.REDIRECT_INSERT, bundle.getString("label.employee.message.add.success"));
		mapMessage.put(WebConstant.REDIRECT_UPDATE, bundle.getString("label.employee.message.update.success"));
		mapMessage.put(WebConstant.REDIRECT_DELETE, bundle.getString("label.employee.message.delete.success"));
		mapMessage.put(WebConstant.REDIRECT_ERROR, bundle.getString("label.message.error"));
		return mapMessage;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmployeeCommand command = FormUtil.populate(EmployeeCommand.class, request);
			EmployeeDTO pojo = command.getPojo();
			System.out.println(command.getCrudaction());
			if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
				if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.INSERT_UPDATE)) {
					Short flag = pojo.getEmpId();
					flag = (short) (flag - 1);
					System.out.println("pojo.empId" + flag);
					System.out.println("getLastId" + getLastInsertId());
					if (pojo != null && pojo.getEmpId() != 0 && flag == getLastInsertId()) {
						System.out.println("save");
						empService.save(pojo);
						request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_INSERT);
					} else {

						empService.update(pojo);
						request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_UPDATE);
					}

				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/employee/edit.jsp");
		rd.forward(request, response);
	}

}
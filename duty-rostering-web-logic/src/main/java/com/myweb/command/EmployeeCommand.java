package com.myweb.command;

import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.web.command.AbstractCommand;

public class EmployeeCommand extends AbstractCommand<EmployeeDTO> {
	public EmployeeCommand() {
		this.pojo = new EmployeeDTO();
	}
}

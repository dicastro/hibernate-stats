package com.qopuir.hibernatestats.core.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qopuir.hibernatestats.core.bo.EmployeeBO;
import com.qopuir.hibernatestats.core.entities.dto.EmployeeDTO;
import com.qopuir.hibernatestats.core.manager.EmployeeManager;

@Component
public class EmployeeBOImpl implements EmployeeBO {
	@Autowired
	private EmployeeManager employeeManager;
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeManager.getAllEmployees();
	}
}
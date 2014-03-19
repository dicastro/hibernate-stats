package com.qopuir.hibernatestats.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qopuir.hibernatestats.core.bo.EmployeeBO;
import com.qopuir.hibernatestats.core.entities.dto.EmployeeDTO;
import com.qopuir.hibernatestats.core.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeBO employeeBO;
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDTO> getAllEmployees() {
		return employeeBO.getAllEmployees();
	}
}
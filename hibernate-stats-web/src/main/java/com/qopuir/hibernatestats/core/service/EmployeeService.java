package com.qopuir.hibernatestats.core.service;

import java.util.List;

import com.qopuir.hibernatestats.core.entities.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> getAllEmployees();
}
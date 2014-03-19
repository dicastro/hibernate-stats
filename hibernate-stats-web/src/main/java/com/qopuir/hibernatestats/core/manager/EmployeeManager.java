package com.qopuir.hibernatestats.core.manager;

import java.util.List;

import com.qopuir.hibernatestats.core.entities.dto.EmployeeDTO;

public interface EmployeeManager {
	public List<EmployeeDTO> getAllEmployees();
}
package com.qopuir.hibernatestats.core.bo;

import java.util.List;

import com.qopuir.hibernatestats.core.entities.dto.EmployeeDTO;

public interface EmployeeBO {
	public List<EmployeeDTO> getAllEmployees();
}
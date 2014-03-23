package com.qopuir.hibernatestats.core.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qopuir.hibernatestats.core.dao.EmployeeDAO;
import com.qopuir.hibernatestats.core.entities.dto.EmployeeDTO;
import com.qopuir.hibernatestats.core.entities.vo.EmployeeVO;
import com.qopuir.hibernatestats.core.manager.EmployeeManager;

@Component
public class EmployeeManagerImpl implements EmployeeManager {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeVO> allEmployees = employeeDAO.findAll();
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		
		for (EmployeeVO employeeVO : allEmployees) {
			employeeDTOList.add(new EmployeeDTO().setId(employeeVO.getId()).setFirstname(employeeVO.getFirstname()).setLastname(employeeVO.getLastname()).setEmail(employeeVO.getEmail()).setTelephone(employeeVO.getTelephone()));
		}
		
		return employeeDTOList;
	}

}

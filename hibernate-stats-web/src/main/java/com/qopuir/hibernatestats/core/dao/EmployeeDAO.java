package com.qopuir.hibernatestats.core.dao;

import java.util.List;

import com.qopuir.hibernatestats.core.entities.vo.EmployeeVO;

public interface EmployeeDAO {
	List<EmployeeVO> findAll();
	EmployeeVO findById(Integer id);
}
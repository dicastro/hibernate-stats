package com.qopuir.hibernatestats.core.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qopuir.hibernatestats.core.dao.EmployeeDAO;
import com.qopuir.hibernatestats.core.entities.vo.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from EmployeeVO").list();
	}
}
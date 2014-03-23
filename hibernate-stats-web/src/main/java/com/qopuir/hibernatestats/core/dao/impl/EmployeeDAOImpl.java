package com.qopuir.hibernatestats.core.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qopuir.hibernatestats.core.dao.EmployeeDAO;
import com.qopuir.hibernatestats.core.entities.vo.EmployeeVO;

@Repository
@Monitored
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> findAll() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return sessionFactory.getCurrentSession().createQuery("from EmployeeVO").list();
	}
	
	@Override
	public EmployeeVO findById(Integer id) {
		return (EmployeeVO) sessionFactory.getCurrentSession().createQuery("from EmployeeVO where id = :id").setInteger("id", id).uniqueResult();
	}
}
package com.qopuir.hibernatestats.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.qopuir.hibernatestats.core.service.EmployeeService;

public class SubmitSearchEmployeesAction extends Action {
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) {
		//SearchEmployeesForm searchEmployeesForm = (SearchEmployeesForm) form;

		request.setAttribute("results", employeeService.getAllEmployees());
		
		return mapping.findForward("success");
	}
}
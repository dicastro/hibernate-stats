package com.qopuir.hibernatestats.web.forms;

import org.apache.struts.action.ActionForm;

public class SearchEmployeesForm extends ActionForm {
	private static final long serialVersionUID = 7104298281697641178L;

	private String firstname;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
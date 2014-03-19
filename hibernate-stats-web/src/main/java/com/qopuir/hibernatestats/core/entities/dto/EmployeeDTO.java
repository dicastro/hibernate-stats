package com.qopuir.hibernatestats.core.entities.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = -3721906545656598766L;
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String telephone;

	public Integer getId() {
		return id;
	}

	public EmployeeDTO setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public EmployeeDTO setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public EmployeeDTO setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public EmployeeDTO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getTelephone() {
		return telephone;
	}

	public EmployeeDTO setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("id", id).append("firstname", firstname).append("lastname", lastname).append("email", email).append("telephone", telephone).build();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(31, 1).append(id).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		EmployeeDTO other = (EmployeeDTO) obj;
		
		return new EqualsBuilder().append(id, other.id).build();
	}
}
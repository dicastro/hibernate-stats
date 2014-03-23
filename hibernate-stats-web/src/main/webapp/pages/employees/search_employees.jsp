<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/tld/c.tld" prefix="c" %>
<%@ taglib uri="/tld/fmt.tld" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search employees</title>
	</head>
	<body>
		<html:form action="/submitSearchEmployees" method="POST">
			<fieldset>
				<div>
					<label for="firstname">Firstname</label>
					<html:text name="searchEmployeesForm" property="firstname" maxlength="50" />
				</div>
				<div>
					<label for="lastname">Lastname</label>
					<html:text name="searchEmployeesForm" property="lastname" maxlength="50" />
				</div>
			</fieldset>
			<div>
				<html:submit value="Search" />
			</div>
		</html:form>
		
		<logic:present name="results" scope="request">
			<bean:size id="employeesFound" name="results" scope="request" />
			
			<logic:empty name="results" scope="request">
				<p>No results</p>
			</logic:empty>
			
			<logic:notEmpty name="results" scope="request">
				<p>Found ${employeesFound} employees</p>
				
				<logic:iterate id="employee" name="results" scope="request">
					<p>${employee.firstname} ${employee.lastname}</p>
				</logic:iterate>
			</logic:notEmpty>
		</logic:present>
		<logic:notPresent name="results" scope="request">
			<p>No results found</p>
		</logic:notPresent>
	</body>
</html>
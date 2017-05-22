<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="addEmp" method="post">
<s:textfield name="empno" label="Enter Empno"/>
<s:textfield name="empname" label="Enter Emp Name"/>
<s:combobox list="country" label="Enter Country" name="co" headerKey="-1" headerValue="select"></s:combobox>
<s:submit/>
</s:form>
</body>
</html>
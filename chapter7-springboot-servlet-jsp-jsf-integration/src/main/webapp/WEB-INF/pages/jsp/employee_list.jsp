<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="../../../css/mystyle.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP-Page-Employee List</title>
</head>
<body>

	<h1> 
		<c:out value="${message}" />
	</h1>
	
	<table border="1" width="100%">
		<tr>
			<th>Çalışan ID</th>
			<th>İsim</th>
			<th>Soyisim</th>
			<th>Cinsiyet</th>
			<th>Doğum Tarihi</th>
			<th>İşe Başlangıç Tarihi</th>
		</tr>

		<c:forEach var="employee" items="${viewEmployees}">
			<tr>
				<td><c:out value="${employee.empNo}"/></td>
				<td><c:out value="${employee.name}"/></td>
				<td><c:out value="${employee.lastName}"/></td>
				<td><c:out value="${employee.gender}"/></td>
				<td><c:out value="${employee.birthDate}"/></td>
				<td><c:out value="${employee.hireDate}"/></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
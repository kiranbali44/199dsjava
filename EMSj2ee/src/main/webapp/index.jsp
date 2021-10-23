<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index page</title>
</head>
<body>
 <marquee>Welcome to EMS:</marquee>
<a href="employee-form.jsp">ADD Employee</a>
 <a href="${pageContext.request.contextPath}/EC?action=LIST">List Employee</a>
</body>
</html>
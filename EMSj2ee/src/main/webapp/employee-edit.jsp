<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<form action="${pageContext.request.contextPath}/EC?action=UPDATE" method="get">
	 <div class="form-group">
    		<label for="txtempid">Employee ID</label>
    		<input type="text" class="form-control" id="txtempid" name="eid" value="${param.eid}"   readonly="readonly">
    </div>
     <div class="form-group">
    		<label for="txtempname">Employee Name</label>
    		<input type="text" class="form-control" id="txtempname" name="ename" value="${param.ename}" >
    </div>
     <div class="form-group">
    		<label for="txtempdept">Department</label>
    		<input type="text" class="form-control" id="txtempdept" name="dept" value="${param.dept}" >
    </div>
    <button type="submit" name="action" value="UPDATE" class="btn btn-primary">Update Employee</button>
  	</form>
  	</div>
</body>
</html>
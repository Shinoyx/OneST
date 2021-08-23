<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OneST - Service 2</title>
</head>
<body>
	<h1>Weather Forecast</h1>
	<form action="Service2" method="post">
		Select location: <select name="areaname">
			<c:forEach var="area" items="${area_data}">
				<option value='${area.name}'>${area.name}</option>
			</c:forEach>
			<input type="submit" value="ok" />
	</form>
</body>
</html>
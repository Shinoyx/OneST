<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OneST</title>
</head>
<body>
	<h1>Welcome to OneST!</h1>
	<ul>
		<li><a href="Service1.jsp" id="service1">Service 1 - UEN Validation</a></li>
		<li>
			<form id="service2" action="Service2" method="get"></form> <a
			href="javascript:{}" id="service2"
			onclick="document.getElementById('service2').submit(); return false;">Service
				2 - Weather Forecast</a>
		</li>
	</ul>
</body>
</html>
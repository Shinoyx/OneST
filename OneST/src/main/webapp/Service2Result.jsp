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
	<b>Date: </b> ${date}
	<br>
	<b>Time from: </b> ${time_start}
	<br>
	<b>Time till: </b> ${time_end}
	<br> ${area_name} ${area_forecast=='' ? "has no data":"will be"}
	<b>${area_forecast}</b>
</body>
</html>
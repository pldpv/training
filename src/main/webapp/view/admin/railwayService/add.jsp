<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Додати службу</title>
</head>
<body>
	<h1>Додати службу</h1>
	<form action="railwayservice" method="post">
	<input type="hidden" name="add">
	<ul>
		<li>Назва: <input type="text" name="name"></li>
		<li>Начальник: <input type="text" name="director"></li>
	</ul>
	<input type="submit" value="add">
	</form>
	<a href="railwayservice?list">До списку служб</a>
</body>
</html>
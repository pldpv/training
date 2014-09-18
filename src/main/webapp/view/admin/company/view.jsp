<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>${company.name}</title>
</head>
<body>
	<h1>${company.name}</h1>
	<ul>
		<c:forEach var="department" items="${company.departments}">
			<li><a href="${department.url}">${department.name}</a></li>
		</c:forEach>
	</ul>
	<a href="${company.url}&edit">Редагувати службу</a> | 
	<a href="department?add">Створити пыдприємство</a>
	| <a href="${company.railwayService.url}">Назад до ${company.railwayService.name}</a>
</body>
</html>
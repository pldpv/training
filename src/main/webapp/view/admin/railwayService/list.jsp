<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Служби Залізниці</title>
</head>
<body>
	<h1>Служби Залізниці</h1>
	<ul>
	<c:forEach var="railwayService" items="${railwayServices}">
		<li><a href="${railwayService.url}">${railwayService.name}</a> </li>
    </c:forEach>
	</ul>
		<a href="railwayservice?add">Створити службу</a> | <a href="admin">На головну</a>
</body>
</html>
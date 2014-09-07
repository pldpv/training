<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Contacts</title>
</head>
<body>
	<h1>Contacts</h1>
	<ul>
	<c:forEach var="contact" items="${contacts}">
		<li><a href="${contact.url}">${contact.name}</a> </li>
    </c:forEach>
	</ul>
		<a href="person?add">add new contact</a> | <a href="company?add">add new company</a>
</body>
</html>
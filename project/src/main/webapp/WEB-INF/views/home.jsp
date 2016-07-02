<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<c:forEach items="${ list }" var="emp_list">
		${ emp_list.emp_no }<br>
	</c:forEach>
</body>
</html>
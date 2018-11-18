<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Movie</title>
</head>
<body>
		<form:form action="/shows/create" method="POST" modelAttribute="show">
    
        <p><form:label path="title"> Title: </form:label></p>
		<p><form:errors path="title"></form:errors> </p>
        <p><form:input path="title"></form:input></p>

        <p><form:label path="network"> Network: </form:label></p>
        <p><form:errors path="network"></form:errors> </p>
        <p><form:input path="network"></form:input></p>

        <p><input type="submit" value="Create Show" /></p>
        
    </form:form>
</body>
</html>
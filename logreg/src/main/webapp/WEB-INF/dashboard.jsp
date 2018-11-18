<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>Welcome, ${ user.first }</h1>
	<h2>Tv Shows</h2>
	<table>
		<thead>
			<th>Show</th>
			<th>Network</th>
			<th>Average Rating</th>
		</thead>
		<tbody>
		<c:forEach var="show" items="${ shows }" >
			<tr> 
				<td><a href="/shows/${ show.id }">${  show.title }</a></td>
				<td> ${  show.network } </td>
				<td> ${  show.rating }</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	<br>
	<br>
	<button><a href="/shows/add">Add Show</a></button>
	
</body>
</html>
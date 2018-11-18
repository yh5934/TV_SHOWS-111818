<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>

<h1>${ show.title }</h1>
	<p>Network: ${show.network }</p>
	<h1> Users who rated the show:</h1>
	<table>
		<thead>
			<th>Name</th>
			<th>Rating</th>
			
		</thead>
		<tbody>
		<%-- <c:forEach var="user" items="${ users }" >
			<tr> 
			
				<td> ${  user.name } </td>
				<td> ${  show.rating }</td>
			</tr>
		</c:forEach>  --%>
		</tbody>
	</table>
	<br>
	<br>
	<button><a href="/shows/edit">Edit</a></button>
	
	<form:form action="/shows/rate/${ user_id }/${ singleShow.id }" method="post" modelAttribute="rating" >
	<h1>Leave a rating:</h1>
	<input type="text" name="RATE">
	<input type="submit" value="Rate!">
	</form:form>
	

</body>
</html>
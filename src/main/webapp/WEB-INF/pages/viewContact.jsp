<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">

$(document).ready(function () {
    $('#cnctTable').DataTable({
        pagingType: 'full_numbers',
    });
});
function confirmDelete(){
	return confirm("DO YOU WANT DELETE THIS RECORD?");
}
</script>
</head>
<body>

	<h2>VIEW CONTACTS HERE</h2>

	<a href="load">+ADD NEW CONTACT </a>
	<br>
	<table border="1" id="cnctTable">
		<thead>
			<tr>
				<th>SR.NO</th>
				<th>NAME</th>
				<th>EMAIl</th>
				<th>PHONE NUMBERM</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contact }" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?cid=${c.contactId}">EDIT</a> | <a
						href="deleteContact?cid=${c.contactId}" onclick="confirmDelete()">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
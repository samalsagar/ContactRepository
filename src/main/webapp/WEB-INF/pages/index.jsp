<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h2>Saved Data</h2>

	<p>
		<font color='green'>${sucMsg} </font>
	</p>
	<p>
		<font color='red'>${errMsg} </font>
	</p>
	
	<p>
		<font color='blue'>${updtateMsg} </font>
	</p>

	<form:form action="saveContact" modelAttribute="contact" method="post" id="frm">

		<table>
			<tr>
			    <form:hidden path="contactId" />
				<td>CONTACT NAME:</td>
				<td><form:input path="contactName"/></td>
			</tr>
			<tr>
				<td>CONTACT EMAIL:</td>
				<td><form:input path="contactEmail"/></td>
			</tr>
			<tr>
				<td>CONTACT NUMBER:</td>
				<td><form:input path="contactNumber" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="save" /></td>
			</tr>
		</table>
	</form:form>
	
	<a href="viewContact">SHOW ALL RECORDS</a>
</body>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" ></script>
</html>
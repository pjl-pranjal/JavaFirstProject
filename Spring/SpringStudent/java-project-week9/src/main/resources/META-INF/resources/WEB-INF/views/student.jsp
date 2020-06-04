<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Look-up</title>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>City</th>
			</tr>
			<tr>
				<td>${ studentID }</td>
				<td>${ studentName }</td>
				<td>${ studentCity }</td>
			</tr>
		</table>
		
		<br>
		<a href="/">Back</a>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <body>
      
      <form action = "add" method = "POST">
         Input date (yyyy-MM-dd): <input type = "text" name = "input_date" />
         <br />
         Value to add: <input type = "text" name = "value_to_add" />
         <br />
         Add to:<input type="radio" id = "day" name="unit_type" value="0">
				<label for="day">Day</label>
				<input type="radio" id = "week" name="unit_type" value="1">
				<label for="week">Week</label>
				<input type="radio" id = "month" name="unit_type" value="2">
				<label for="month">Month</label>
				<input type="radio" id = "year" name="unit_type" value="3">
				<label for="year">Year</label>
		 <br />
         <input type = "submit" value = "Submit" />
      </form>
      
      Result: <c:out value="${result}"></c:out>
   </body>
</html>
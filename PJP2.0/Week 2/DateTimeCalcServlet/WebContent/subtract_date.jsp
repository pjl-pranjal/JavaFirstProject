<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <body>
      
      <form action = "subtract-date" method = "POST">
         Input date 1 (yyyy-MM-dd): <input type = "text" name = "input_date1" />
         <br />
         Input date 2 (yyyy-MM-dd): <input type = "text" name = "input_date2" />
         <br />
         <input type = "submit" value = "Submit" />
      </form>
      
      Result: <c:out value="${result}"></c:out>
   </body>
</html>
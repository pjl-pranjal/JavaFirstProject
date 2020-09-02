<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <body>
      
      <form action = "nl" method = "POST">
         NL Phrase: <input type = "text" name = "phrase" />
         <br />
         <input type = "submit" value = "Submit" />
      </form>
      
      Result: <c:out value="${result}"></c:out>
   </body>
</html>
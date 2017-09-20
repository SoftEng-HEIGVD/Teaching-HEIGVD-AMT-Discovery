<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Actors</h1>
    <table>
      <c:forEach items="${actors}" var="actor"> 
        <tr>
          <td>${actor.id}</td>
          <td>${actor.firstName}</td>
          <td>${actor.lastName}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

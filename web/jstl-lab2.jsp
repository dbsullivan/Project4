<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>
  <head>
    <title>JSTL lab2</title>
  </head>
  <body>
    <table border="2">
      <c:forEach var="flower" items="${flowersList}">
          <tr>
            <td>${flower}</td>
          </tr>  
      </c:forEach>
    </table>
    <!--a href='/java112'>Dave Sullivan Java112 Home</a -->
    <a href='/java112'>Dave Sullivan Java112 Home</a>
  </body>
</html>


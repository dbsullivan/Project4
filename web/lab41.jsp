<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <c:set var="name" value="Dave" /> -->

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
      
    <title>HTML Forms Lab</title>
  </head>
    
  <body>
    <h4>HTML Forms Lab</h4>
      
    <form action="/java112/Lab41Servlet" method="GET">
      <input type="text" name="param1" /><br />
      <br />
       <input type="text" name="param2" value="default value" /><br />
      <br />
        <input type="radio" name="gender" value="M" />Male<br>
        <input type="radio" name="gender" value="F" />Female<br>
      <br />      
       <input type="submit" name="" value="Enter" />
    </form>
  </body>
</html>
  





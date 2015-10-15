
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- head -->
<c:import url="template_head_tag.jsp" /> 
<body>

	<!-- header -->
    <c:import url="template_header.jsp" /> 	
    <!--end header -->
    
    <!-- main -->
    <div id="main">
	    <!--begin sidebar -->
          <div id="sidebar">
          <!--      <a href="/java112"><img src="images/clover.jpg" alt="Dave Sullivan Java112 Home" align="left" width=200 height=150 /></a>
            -->
            
          </div>
  
          <div id="text"  >
       <h2>Project 4 Startup</h2>
        <table border=1 color="WHITE">
            <tr>
            <th> Employee </th>
            <th> Value </th>
            <tr> </tr>
                <tr>
                <td> Search Type </td>
                <td> ${project4StatusSearch.searchType} </td>
                </tr>   
                <tr>
                <td> Search Term </td>
                <td> ${project4StatusSearch.searchTerm} </td>
                </tr>   
                <tr>
                <td> Employee List </td>
                <td> ${project4StatusSearch.employeesList}</td>
                </tr>                   
        </table> 
        </br>
        <a href='/java112'>Dave Sullivan Java112 Home</a>
          </div>
    </div>
    <!-- end main -->
    
    <!-- footer -->
    <c:import url="template_footer.jsp" /> 
    <!-- end footer -->
</body>
</html>
  

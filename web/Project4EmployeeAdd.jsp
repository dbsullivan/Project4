<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- head -->
<c:import url="template_head_tag.jsp" /> 
<%-- <c:set var="textAreaColor" value="#ffffff" scope="session" />  --%>

<%! 
    private String textAreaWhite = "#ffffff"; 
    private String textAreaHighlight = "#fffd48"; 
    private String textAreaColor = "";
%>

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
          
    <h2>Project 4 Employee Add Form</h2>
    <h4>Add Messages: ${project4AddMessage}</h4>      
    <form action="/java112/project4-add-action" method="POST">
    <table>  
      <tr>
          <td align="left">Employee First Name:</td>
          <td align="left"><%-- input type="text" name="firstName" maxlength="25" size="30" value="${firstName}" style="background-color:#ffffff;"/ --%>          
          <c:choose>          
             <c:when test="${project4firstNameErr == true}" >
                <input type="text" name="firstName" maxlength="25" size="30" value="${firstName}" style="background-color:<%= textAreaHighlight %> ;" /> 
             </c:when>   
             <c:otherwise>
                <input type="text" name="firstName" maxlength="25" size="30" value="${firstName}" style="background-color:<%= textAreaColor %> ;" /> 
             </c:otherwise>          
          </c:choose>                           
          </td> 
      </tr>  
      <tr>      
          <td align="left">Employee Last Name:</td>
          <td align="left"><%-- <input type="text" name="lastName" maxlength="30" size="30" value="${lastName}" /></td> --%>
          <c:choose>          
             <c:when test="${project4lastNameErr == true}" >
                <input type="text" name="lastName" maxlength="30" size="30" value="${lastName}" style="background-color:<%= textAreaHighlight %> ;" /> 
             </c:when>   
             <c:otherwise>
                <input type="text" name="lastName" maxlength="30" size="30" value="${lastName}" style="background-color:<%= textAreaColor %> ;" /> 
             </c:otherwise>          
          </c:choose>                           
          </td>           
      </tr>  
      <tr>      
          <td align="left">Employee SSN:</td>
          <td align="left"><%-- <input type="text" name="ssn" maxlength="20" size="30" value="${ssn}" /></td> --%>
          <c:choose>          
             <c:when test="${project4ssnErr == true}" >
                <input type="text" name="ssn" maxlength="20" size="30" value="${ssn}" style="background-color:<%= textAreaHighlight %> ;" /> 
             </c:when>   
             <c:otherwise>
                <input type="text" name="ssn" maxlength="20" size="30" value="${ssn}" style="background-color:<%= textAreaColor %> ;" /> 
             </c:otherwise>          
          </c:choose>                           
          </td>                     
      </tr>
      <tr> 
          <td align="left">Employee Department:</td>
          <td align="left"><%-- <input type="text" name="department" maxlength="10" size="30" value="${department}" /></td> --%>
          <c:choose>          
             <c:when test="${project4departmentErr == true}" >
                <input type="text" name="department" maxlength="10" size="30" value="${department}" style="background-color:<%= textAreaHighlight %> ;" /> 
             </c:when>   
             <c:otherwise>
                <input type="text" name="department" maxlength="10" size="30" value="${department}" style="background-color:<%= textAreaColor %> ;" /> 
             </c:otherwise>          
          </c:choose>                           
          </td>                               
      </tr>
      <tr>
          <td align="left">Employee Room Number:</td>
          <td align="left"><%-- <input type="text" name="roomNumber" maxlength="10" size="30" value="${roomNumber}" /></td> --%>
          <c:choose>          
             <c:when test="${project4roomNumberErr == true}" >
                <input type="text" name="roomNumber" maxlength="10" size="30" value="${roomNumber}" style="background-color:<%= textAreaHighlight %> ;" /> 
             </c:when>   
             <c:otherwise>
                <input type="text" name="roomNumber" maxlength="10" size="30" value="${roomNumber}" style="background-color:<%= textAreaColor %> ;" /> 
             </c:otherwise>          
          </c:choose>                           
          </td>                                         
      </tr>
      <tr>
          <td align="left">Employee Phone Number:</td>
          <td align="left"><%-- <input type="text" name="phoneNumber" maxlength="10" size="30" value="${phoneNumber}" /></td> --%> 
          <c:choose>          
             <c:when test="${project4phoneNumberErr == true}" >
                <input type="text" name="phoneNumber" maxlength="10" size="30" value="${phoneNumber}" style="background-color:<%= textAreaHighlight %> ;" /> 
             </c:when>   
             <c:otherwise>
                <input type="text" name="phoneNumber" maxlength="10" size="30" value="${phoneNumber}" style="background-color:<%= textAreaColor %> ;" /> 
             </c:otherwise>          
          </c:choose>                           
          </td>                        
      </tr>
    </table>  
      <br />    
      <input type="submit" name="" value="Enter" />
    </form>
    
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
  





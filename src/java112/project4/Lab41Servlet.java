package java112.project4;
  
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

  
/**
 *  This class demonstrates getting input fields from an HTML form (inside lab41.jsp)
 *
 *@author    Dave Sullivan
 */
@WebServlet(
    name = "requestParam",
    urlPatterns = { "/Lab41Servlet" }
)
public class Lab41Servlet extends HttpServlet {
  
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws ServletException, IOException {
  
        String  param1  = request.getParameter("param1");
  
        System.out.println("param1: " + param1);  // goes to Catalina out
  
        String  param2  = request.getParameter("param2");
  
        System.out.println("param2: " + param2);
        
        String  gender  = request.getParameter("gender");
        
        System.out.println("gender: " + gender);
        
        request.setAttribute("parameter1Value",param1);
        request.setAttribute("parameter2Value",param2);
        request.setAttribute("genderValue",gender);        
        
        // Forward to a JSP page named lab41out.jsp.        
        String url = "/lab41out.jsp";
                 
        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);                         
        
    }
  
}

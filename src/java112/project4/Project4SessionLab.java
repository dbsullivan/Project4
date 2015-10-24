package java112.project4;
  
import java.io.*;
import java.util.*;
//import java112.employee.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
  
/**
 *  This is part of module 4 and demonstrates
 *  getting and setting attributes in the session.
 *
 *@author    Dave Sullivan
 */
@WebServlet(
    name = "Project 4 Session Lab",
    urlPatterns = { "/Project4SessionLab" }
)
public class Project4SessionLab extends HttpServlet {
  
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
  
        //response.setContentType("text/html");
        //PrintWriter  out          = response.getWriter();
  
        HttpSession  session      = request.getSession();
        
        Integer sessionCounter  =
                (Integer) session.getAttribute("project4SessionCounter");
  
        //out.print("<html><head></head><body><h3>Getting and "
        //        + "Setting a session attribute in a Servlet</h3><h4>");
  
        if (sessionCounter == null ) {
        //    out.print("myAttribute not found, creating myAttribute");
            sessionCounter = new Integer(1);        
            session.setAttribute("project4SessionCounter", sessionCounter);
        } else {
            sessionCounter++;            
            session.setAttribute("project4SessionCounter", sessionCounter);
            
        //    out.print("myAttribute found: ");
        //    out.print(myAttribute);
        }
  
        //out.print("</body></html>");
        
        // Forward to a JSP page named jstl-lab2.jsp.        
        String url = "/project4Session.jsp";
                 
        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
        
    }
  
}

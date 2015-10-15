package java112.project4;

import java112.employee.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 *  This class provides a forward to a JSP for Employee Add entry (inside Project4EmployeeAdd.jsp).
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "EmployeeAdd",
        urlPatterns = { "/project4-add" }
)
public class Project4AddPageDisplayServlet extends HttpServlet {

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

        System.out.println("In Project4AddPageDisplayServlet servlet, will forward to Project4EmployeeAdd.jsp");

        // Forward to a JSP page named Project4EmployeeAdd.jsp.        
        String url = "/Project4EmployeeAdd.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}

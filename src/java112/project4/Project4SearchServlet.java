package java112.project4;

import java112.employee.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 *  This class provides controller following submit of Employee search- form action in Project4EmployeeSearch.jsp)
 *  Here, Project4SearchServlet.java (project4-results)- decides if Employee found using Search object boolean search.isFound()
 *  if found, display Employee.jsp, else return with message to Project4EmployeeSearch.jsp
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "EmployeeSearchResults",
        urlPatterns = { "/project4-results" }
)
public class Project4SearchServlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        System.out.println("In Project4SearchServlet...get form parms Term/Type set into search object, forward or return");
        String url = null;

        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        EmployeeDirectory employeeDirectory =
                (EmployeeDirectory) getServletContext().getAttribute("employeeDirectory");

        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        // associate the Message with the request, and clear it before forwarding to JSP page 
        String Proj4SearchMessage = "";
        session.setAttribute("project4SearchMessage", Proj4SearchMessage);

        //set message on page use EL request or session.getAttribute(project4SearchMessage); fill if errors.
        if ((search.getSearchTerm() == null || search.getSearchTerm().equals("") )
                &
                (search.getSearchType() == null || search.getSearchType().equals("") )
                ) {
            // Forward back to a JSP page named Project4EmployeeSearch.jsp                      
            System.out.println("return to search JSP, incomplete parms..." + search.getSearchType() + " " + search.getSearchTerm());
            Proj4SearchMessage = "Please enter missing Search Term and Search Type.";
            session.setAttribute("project4SearchMessage", Proj4SearchMessage);
            url = "/Project4EmployeeSearch.jsp";
        } else if (search.getSearchTerm() == null || search.getSearchTerm().equals("") ) {
            // Forward back to a JSP page named Project4EmployeeSearch.jsp                      
            System.out.println("return to search JSP, incomplete parms..." + search.getSearchType() + " " + search.getSearchTerm());
            Proj4SearchMessage = "Please enter missing Search Term.";
            session.setAttribute("project4SearchMessage", Proj4SearchMessage);
            url = "/Project4EmployeeSearch.jsp";
        } else if (search.getSearchType() == null || search.getSearchType().equals("") ) {
            // Forward back to a JSP page named Project4EmployeeSearch.jsp                      
            System.out.println("return to search JSP, incomplete parms..." + search.getSearchType() + " " + search.getSearchTerm());
            Proj4SearchMessage = "Please enter missing Search Type.";
            session.setAttribute("project4SearchMessage", Proj4SearchMessage);
            url = "/Project4EmployeeSearch.jsp";
        } else {
            // Forward to a JSP page named Project4SearchResults.jsp             
            System.out.println("forward to Project4SearchResults.jsp, with servletContext employeeDirectory.searchForEmployee(search)") ;
            search = employeeDirectory.searchForEmployee(search);
            session.setAttribute("project4StatusSearch", search);

            if ( !search.isFound() ) {
                Proj4SearchMessage = "No Employee found.";
                session.setAttribute("project4SearchMessage", Proj4SearchMessage);
            }

            url = "/Project4SearchResults.jsp";
        }

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

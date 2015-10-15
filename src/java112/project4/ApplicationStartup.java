package java112.project4;

import java112.employee.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *@author     Dave Sullivan class ApplicationStartup
 *
 */

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" } ,
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet {

    private Properties  properties;
    private EmployeeDirectory  employees;

    /**
     *  Initialize this servlet
     *
     *@exception  ServletException  Description of the Exception
     */
    public void init() throws ServletException {
        System.out.println("ApplicationStartup.init()...begin" );  // in Catalina, we want to see it ran

        ServletContext  context = getServletContext();

//        String propsPath = "/project4.properties";
        String propsPath = "project4.properties";

        loadProperties(propsPath);

        context.setAttribute("proj4Properties", properties); // load in context so any servlet can get this        

        employees = new EmployeeDirectory(properties);
        context.setAttribute("employeeDirectory", employees); // load context with employees for any servlet to get this       

        System.out.println("ApplicationStartup.init()" + "Uname: " + properties.getProperty("username") +
                "  Pswd: " + properties.getProperty("password") +
                "  Props URL: " + properties.getProperty("url") ); // test

        System.out.println("ApplicationStartup.init()...end" );  // in Catalina, we want to see it ran       
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param request               the HttpServletRequest object
     *@param response              the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Application Startup.doGet()...begin");

        HttpSession session = request.getSession();

        // ask - why again here?  this one is for local test
        EmployeeDirectory employeeDirectory =
                (EmployeeDirectory) getServletContext().getAttribute("employeeDirectory");

        //Search search = null;    
        //search = employeeDirectory.searchForEmployee("id","123");// test connection simple search

        Search search = new Search();
        search.setSearchType("id");
        search.setSearchTerm("123");

        // ask
        search = employeeDirectory.searchForEmployee(search);  // test connection simple search         

        session.setAttribute("project4StatusSearch", search);    // getAttribute in the result display jsp from this.               
        session.setAttribute("project4Properties", properties);  // load in context so any servlet can get this       

        String url = "/Project4Startup.jsp"; // forward to JSP page

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        PrintWriter out = response.getWriter();
        out.print("<a href=\'/java112'>Dave Sullivan Java112 Home</a>");
        out.close();

        System.out.println("Application Startup.doGet()...end");

    }

    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }

}

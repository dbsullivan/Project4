package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *@author     Dave Sullivan class PropertiesServlet
 *
 */
@WebServlet(
        name = "project3PropertiesServlet",
        urlPatterns = { "/project3-properties" }
)
public class PropertiesServlet extends HttpServlet {


    private Properties properties;

    /**
     *  Description of the Method
     *
     *@exception ServletException  Description of the Exception
     */
    public void init() throws ServletException {
        // Initialization code
        loadProperties("project3.properties");
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

        response.setContentType("text/html");
        // set the response type before sending data
        request.setAttribute("propertiesBean", properties);

        // Forward to a JSP page named propertiesJSP.jsp.
        String url = "/propertiesJSP.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        PrintWriter out = response.getWriter();
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("<a href=\'/java112'>Dave Sullivan Java112 Home</a>");
        out.close();

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


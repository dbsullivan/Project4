package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *@author     Dave Sullivan class PropertiesServlet
 *
 */
@WebServlet(name = "properties-servlet", urlPatterns = { "/project2-properties" })
public class PropertiesServlet extends HttpServlet {


    private Properties properties;

    /**
     *  Description of the Method
     *
     *@exception ServletException  Description of the Exception
     */
    public void init() throws ServletException {
        // Initialization code
//        loadProperties("/project2.properties");
        loadProperties("project2.properties");
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param request               the HttpServletRequest object
     *@param response              the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// my code here to get the properties into HTML table
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>PropertiesServlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>PropertiesServlet</h1>");
        out.print("<table border='1'>");
        out.print("<caption>These are the project properties</caption>");
        out.print("<tr><th>Property Name</th><th>Property Value</th></tr>");
        out.print("<tr><td>author</td><td>" + properties.getProperty("author") + "</td>");
        out.print("<tr><td>email</td><td>" + properties.getProperty("email") + "</td>");
        out.print("<tr><td>course.title</td><td>" + properties.getProperty("course.title") + "</td>");
        out.print("<tr><td>course.date</td><td>" + properties.getProperty("course.date") + "</td>");
        out.print("<tr><td>course.instructor</td><td>" + properties.getProperty("course.instructor") + "</td>");
        out.print("<tr><td>course.description</td><td>" + properties.getProperty("course.description") + "</td>");
        out.print("</table>");
        out.print("<p><a href='" + "/java112'>Dave Sullivan Java112 Home</a></p>");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
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

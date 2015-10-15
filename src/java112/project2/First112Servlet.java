package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "First112Servlet",
        urlPatterns = { "/First112", "/first112" }
)
public class First112Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param request                   the HttpServletRequest object
     *@param response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First112Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>First112Servlet</h1>");
        out.print("<p>Dave Sullivan</p>");
        out.print("<p>Course: Java112</p>");
        out.print("<a href='" + "/java112'>Dave Sullivan Java112 Home</a>");
        out.print("<p><a href='/java112'><img src='images/clover.jpg' /></a></p");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}



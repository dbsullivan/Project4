package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab Lab3-2.
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "Lab32Servlet",
        urlPatterns = { "/Lab32Servlet", "/lab32" }
)
public class Lab32Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>Lab32Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1 align=CENTER>Lab32Servlet</h1>");
        out.print("<p>HttpServerRequest Object values in unordered list</p>");
        out.print("<ul>");
        out.print("<li>Request Locale: " + request.getLocale() + "</li>");
        out.print("<li>Request Context Path: " +  request.getContextPath() + "</li>");
        out.print("<li>Request Server Name: " + request.getServerName() + "</li>");
        out.print("<li>Request Scheme: " + request.getScheme() + "</li>");
        out.print("</ul>");
//        out.print("<a href=" + "'/java112'>Dave Sullivan Java112 Home</a>");
        out.print("<a href=\'/java112\'>Dave Sullivan Java112 Home</a>");
//        out.print("<p><a href='/java112'><img src='images/clover.jpg' /></a></p");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}



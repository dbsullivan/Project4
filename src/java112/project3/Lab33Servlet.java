package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;  // for Hashmap and Date class

/**
 *  This is part of a lab Lab3-3.
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "Lab33Servlet",
        urlPatterns = { "/Lab33Servlet", "/lab33" }
)
public class Lab33Servlet extends HttpServlet {

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

        Map map = new HashMap();

        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This is an h2</h2>");
        map.put("aDate", new Date());

        request.setAttribute("myMap", map);

        // Forward to a JSP page named lab33.jsp.
        String url = "/lab33.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        PrintWriter  out  = response.getWriter();
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("<a href=\'/java112'>Dave Sullivan Java112 Home</a>");
        out.close();

    }

}



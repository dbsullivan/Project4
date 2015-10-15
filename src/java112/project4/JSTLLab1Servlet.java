package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;  // for Hashmap and Date class

/**
 *  This is part of a JSTL Lab1 Servlet
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "JSTLLab1Servlet",
        urlPatterns = { "/JSTLLab1Servlet" }
)
public class JSTLLab1Servlet extends HttpServlet {

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
        //response.setContentType("text/html");
        // set the response type before sending data

        // HttpSession  session  = request.getSession();
        HttpSession  session  = request.getSession();

        List flowers = new ArrayList();
        flowers.add("Tulip");
        flowers.add("Rose");
        flowers.add("Daffodil");
        flowers.add("Petunia");
        flowers.add("Lily");

        session.setAttribute("flowersList", flowers);

        // Forward to a JSP page named jstl-lab2.jsp.        
        String url = "/jstl-lab2.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        //PrintWriter  out  = response.getWriter(); 
        //System.out.println("Is this logging?");
        //log("Is this logging?");

        //out.print("<a href=\'/java112'>Dave Sullivan Java112 Home</a>");            
        //out.close();        

    }

}


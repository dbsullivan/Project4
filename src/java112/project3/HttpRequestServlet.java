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
        name = "requestServlet",
        urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {

    /**
     *  Description of the Method
     *
     *@exception ServletException  Description of the Exception
     */
    public void init() throws ServletException {
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

        //create the new JavaBean to hold Http request data from this HttpRequestServlet
        HttpRequestData httpRequestData = new HttpRequestData();

        //set the JavaBean instance variables, with gets from the HttpServletRequest Interface methods

        httpRequestData.setRemoteHost(request.getRemoteHost()); // The remote computer making the request
        httpRequestData.setRemoteAddr(request.getRemoteAddr()); // The address of the remote computer making the request
        httpRequestData.setRequestHttpMethod(request.getMethod()); // The HTTP method of the request
        httpRequestData.setRequestURI(request.getRequestURI()); // The request URI
        httpRequestData.setRequestURL(request.getRequestURL()); // The request URL
        httpRequestData.setProtocol(request.getProtocol()); // The protocol of the request
        httpRequestData.setServerName(request.getServerName()); // The server name
        httpRequestData.setServerPort(request.getServerPort()); // The server port number
        httpRequestData.setLocale(request.getLocale().toString()); // The current Locale of the server
        httpRequestData.setQueryString(request.getQueryString()); // The query string
        httpRequestData.setQueryParameter(request.getParameter("queryParameter")); // The value of a query parameter with the name of “queryParameter”
        httpRequestData.setRequestHeader(request.getHeader("User-Agent")); // The value of the request header with the name of “User-Agent”

        response.setContentType("text/html");
        // set the response type before sending data
        request.setAttribute("requestDataBean", httpRequestData);
        // associate the JavaBean with the request before forwarding to JSP page

        // Forward to a JSP page named HttpRequestJSP.jsp.
        String url = "/HttpRequestJSP.jsp";

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




package java112.project4;

import java112.employee.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 *  This class gets the entry form parameters and upon submit will Insert a new Employee record.
 *  Input data getParameters from the Project4EmployeeAdd.jsp HTML Form, action to the annotation (project4-add-action) to this Servlet.
 *  following SQL Insert, this servlet is redirected back to the page Project4EmployeeAdd.jsp.
 *
 *@author    Dave Sullivan
 */
@WebServlet(
        name = "EmployeeAddAction",
        urlPatterns = { "/project4-add-action" }
)
public class Project4AddServlet extends HttpServlet {

    /**
     *  Handles HTTP POST requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        System.out.println("In Project4AddServlet...get form parms of Employee, set into INSERT sql, return to add.");
        String url = null;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        String department = request.getParameter("department");
        String roomNumber = request.getParameter("roomNumber");
        String phoneNumber = request.getParameter("phoneNumber");

        // These session properties will persist between validations, in the JSP, input tag, text value="${EL item}".
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("ssn", ssn);
        session.setAttribute("department", department);
        session.setAttribute("roomNumber", roomNumber);
        session.setAttribute("phoneNumber", phoneNumber);

        EmployeeDirectory employeeDirectory =
                (EmployeeDirectory) getServletContext().getAttribute("employeeDirectory");

        // associate the Message with the request, and clear it before forwarding to JSP page     
        String AddMessage = "";
        boolean firstNameErr = false;
        boolean lastNameErr = false;
        boolean ssnErr = false;
        boolean departmentErr = false;
        boolean roomNumberErr = false;
        boolean phoneNumberErr = false;

        // Validate that all fields have valid data, prior to employeeDirectory.Add() 

        if (firstName == null || firstName.equals("") ) {
            AddMessage = "Please enter missing First Name.";
            firstNameErr = true;
        } else if (lastName == null || lastName.equals("")) {
            AddMessage = "Please enter missing Last Name.";
            lastNameErr = true;
        } else if (ssn == null || ssn.equals("")) {
            AddMessage = "Please enter missing SSN.";
            ssnErr = true;
        } else if (department == null || department.equals("")) {
            AddMessage = "Please enter missing Department.";
            departmentErr = true;
        } else if (roomNumber == null || roomNumber.equals("")) {
            AddMessage = "Please enter missing Room Number.";
            roomNumberErr = true;
        } else if (phoneNumber == null || phoneNumber.equals("")) {
            AddMessage = "Please enter missing Phone Number.";
            phoneNumberErr = true;
        } else {
            employeeDirectory.addNewEmployee(firstName, lastName, ssn
                    , department, roomNumber, phoneNumber);
            AddMessage = "Employee added.";
        }

        session.setAttribute("project4AddMessage", AddMessage);
        session.setAttribute("project4firstNameErr", firstNameErr);
        session.setAttribute("project4lastNameErr", lastNameErr);
        session.setAttribute("project4ssnErr", ssnErr);
        session.setAttribute("project4departmentErr", departmentErr);
        session.setAttribute("project4roomNumberErr", roomNumberErr);
        session.setAttribute("project4phoneNumberErr", phoneNumberErr);

        url = "/java112/Project4EmployeeAdd.jsp";  // do a redirect using url back to Project4EmployeeAdd.jsp page.
        response.sendRedirect(url);
    }
}    

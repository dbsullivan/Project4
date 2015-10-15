package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *  This is a class that maintains Employee data to be used by Project4 
 *
 *@author     Dave Sullivan  class EmployeeDirectory
 */
public class EmployeeDirectory extends HttpServlet {

    private Properties properties;

    /**
     *  Constructor (default) for the EmployeeDirectory object
     */
    public EmployeeDirectory() {
    }

    /**
     *  Constructor for the EmployeeDirectory object
     *
     *@param properties  The new properties object with db connection information     
     */
    public EmployeeDirectory(Properties properties) {
        this.properties = properties;

        System.out.println("constructor EmployeeDirectory(Properties properties)... db connect,read search object, run SQL, set Employee");
        System.out.println("Uname: " + properties.getProperty("username") +
                "  Pswd: " + properties.getProperty("password") +
                "  Props URL: " + properties.getProperty("url") ); // test
    }

    /**
     * a method that will add a new record to the Employee table in the database. This method will have the following features:
     * <P>
     * The method will have an argument for each of the instance variables in the Employee class.
     * The method will get a connection to the database.
     * The method will generate a SQL insert statement.
     * The method will run the correct JDBC code to insert the new employee into the database including all necessary exception handling.
     */
    public void addNewEmployee(String firstName, String lastName,
                               String ssn, String department, String roomNumber, String phoneNumber )
    //throws SQLException
    {

        System.out.println("method addNewEmployee() in EmployeeDirectory servlet");

        Connection connection = null;
        Statement statement = null;

        try {

            connection = getDatabaseConnection();
            connection.setAutoCommit(false);  // override the default, we will commit.

            statement = connection.createStatement();

            String insertSQL = "insert into employees ("
                    + " first_name, last_name, ssn, dept, room, phone) values "
                    + "('" + firstName + "', '" + lastName + "', '" + ssn + "', '"
                    + department + "', '" + roomNumber + "', '" + phoneNumber
                    + "');" ;

            System.out.println(); // test   
            System.out.println("method addNewEmployee insertSQL: " + insertSQL);  // test

            int rowsAffected = statement.executeUpdate(insertSQL);

            //connection.rollback();
            connection.commit(); // if we didn't catch exception, we can commit, else rollback.

            System.out.println(); // test            
            System.out.println("number of inserted rows: " + rowsAffected);
            System.out.println(); // test

        } catch (SQLException sqlException) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException sqlException2) {
                    System.err.println("Error in connection.ecting to database "
                            + sqlException2);
                    sqlException2.printStackTrace();
                }
            }
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }
    }


    /**
     * Create a method that will search for an Employee using a Search object by either id or Lastname.
     *
     *@param search  The search Employee method returns a Search object. Can search by ID or Lastname.
     */
    public Search searchForEmployee(Search search) {

        // test employee
        //Employee employee = new Employee();  // in loop, if found, create employee object from db data
        //employee.setLastName("Smith");   
        //employee.setFirstName("Will"); 
        //employee.setEmployeeID("123");       
        //employees.add(employee);
        //search.setEmployeesList(employees); 

        System.out.println("method searchForEmployee() in EmployeeDirectory servlet, with type: " + search.getSearchType());

        if (search.getSearchType().equals("id")) {
            searchForEmployeeID(search);
        }  else
        if (search.getSearchType().equals("name")) {
            searchForEmployeeName(search);
        }

        return search;
    }

    /**
     * Create a method that will search for an Employee in the database by employee id. It will have the following features:
     *
     *@param search  The new search object holds search type, term, results.
     */
    private void searchForEmployeeID(Search search) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        search.setEmployeesFound(false);

        try {

            connection = getDatabaseConnection();

            statement = connection.createStatement();

            //String name = "Smith";  //test
            String term = search.getSearchTerm();
            String queryString = "SELECT emp_id, first_name, last_name"
                    + ",ssn, dept, room, phone"
                    + " FROM employees " + "WHERE emp_id = " + term + " ;"  ;

            System.out.println("method searchForEmployeeID(search) queryString: " + queryString);  // test

            resultSet = statement.executeQuery(queryString);

            System.out.println(); // test

            // load the employee ArrayList of the Search object, then can loop over using JSP with EL tag.
            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                        + firstName + " " + lastName); //test

                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getString("emp_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSsn(resultSet.getString("ssn"));
                employee.setDepartment(resultSet.getString("dept"));
                employee.setRoomNumber(resultSet.getString("room"));
                employee.setPhoneNumber(resultSet.getString("phone"));

                search.addFoundEmployee(employee);
                search.setEmployeesFound(true);

            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }

    }


    /**
     *  method to search by Employee LastName. Dimilar to search by Employee ID, differs by SQL.
     *
     *@param search  The new search object holds search type, term, results.
     */
    private void searchForEmployeeName(Search search) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        search.setEmployeesFound(false);

        try {

            connection = getDatabaseConnection();

            statement = connection.createStatement();

            String term = search.getSearchTerm().trim();  // trim prevents blank from returning ALL employess.           
            String queryString = "SELECT emp_id, first_name, last_name"
                    + ",ssn, dept, room, phone"
                    + " FROM employees " + "WHERE last_name like '" + term + "%'" ;

            System.out.println("method searchForEmployeeName(search) queryString: " + queryString);  // test

            resultSet = statement.executeQuery(queryString);

            System.out.println();  //test

            // load the employee ArrayList of the Search object, then can loop over using JSP with EL tag.
            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                        + firstName + " " + lastName);  //test

                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getString("emp_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setSsn(resultSet.getString("ssn"));
                employee.setDepartment(resultSet.getString("dept"));
                employee.setRoomNumber(resultSet.getString("room"));
                employee.setPhoneNumber(resultSet.getString("phone"));

                search.addFoundEmployee(employee);
                search.setEmployeesFound(true);

            }
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            }
        }

    }

    /**
     *  method to get database connection object
     *
     */
    private Connection getDatabaseConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

//            connection = DriverManager.getConnection(            
//               "jdbc:mysql://localhost/student", "student", "student");  // test hardcoded connect string

            System.out.println("method getDatabaseConnection()" + "Uname: " + properties.getProperty("username") +
                    "  Pswd: " + properties.getProperty("password") +
                    "  Props URL: " + properties.getProperty("url") ); // test

            connection = DriverManager.getConnection(
                    properties.getProperty("url"), properties.getProperty("username")
                    , properties.getProperty("password") );

        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }

        return connection;
    }

}


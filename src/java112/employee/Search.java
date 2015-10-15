package java112.employee;

import java.util.*; // for the ArrayList

/**
 *  This is a JavaBean holding Search type and data to be used by Project4 
 *
 *@author    Dave Sullivan
 */
public class Search extends java.lang.Object {
    //JavaBean: default constuctor (empty), instance vars, getters/setters

    private String searchType;
    private String searchTerm;
    private boolean employeesFound;
    //private ArrayList<Employee> employeesList;
    private ArrayList<Employee> employeesList = new ArrayList<Employee>();

    /**
     *  Constructor for the Search object
     */
    public Search() {

    }

    /**
     *  Gets the searchType attribute of the Search object
     *
     *@return The searchType value
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     *  Gets the searchTerm attribute of the Search object
     *
     *@return The searchTerm value
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     *  Gets the employeesFound attribute of the Search object
     *
     *@return The employeesFound value
     */
    public boolean isFound() {
        return employeesFound;
    }

    /**
     *  Gets the employeesList attribute of the Search object
     *
     *@return The employeesList value
     */
    public ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

/******************************************************************************/

    /**
     *  Sets the searchType attribute of the Search object
     *
     *@param searchType  The new searchType value
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     *  Sets the searchTerm attribute of the Search object
     *
     *@param searchTerm  The new searchTerm value
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     *  Sets the employeesFound attribute of the Search object
     *
     *@param employeesFound  The new employeesFound value
     */
    public void setEmployeesFound(boolean employeesFound) {
        this.employeesFound = employeesFound;
    }

    /**
     *  Sets the employeesList attribute of the Search object
     *
     *@param employeesList  The new employeesList value
     */
    public void setEmployeesList(ArrayList<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    /**
     *  Adds to the employeesList attribute of the Search object
     *
     *@param employee  The new employee value to add to the list
     */
    public void addFoundEmployee(Employee employee) {

        System.out.println("method Search.addFoundEmployee(): " + employee);
        employeesList.add(employee);
    }

}

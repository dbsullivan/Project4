package java112.employee;

/**
 *  This is a JavaBean holding Employee data to be used by Project4 
 *
 *@author    Dave Sullivan
 */
public class Employee extends java.lang.Object {
    //Bean: default constuctor (empty), instance vars, getters/setters
    private String employeeID;
    private String firstName;
    private String lastName;
    private String ssn;
    private String department;
    private String roomNumber;
    private String phoneNumber;

    /**
     *  Constructor for the Employee object
     */
    public Employee() {
        // add each attribute, getter/setter of the request data bean
        employeeID  = "default value";
        firstName  = "default value";
        lastName  = "default value";
        ssn  = "default value";
        department = "default value";
        roomNumber  = "default value";
        phoneNumber = "default value";

    }

    /**
     *  Gets the employeeID attribute of the Employee object
     *
     *@return The employeeID value
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     *  Gets the firstName attribute of the Employee object
     *
     *@return The firstName value
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *  Gets the lastName attribute of the Employee object
     *
     *@return The lastName value
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *  Gets the ssn attribute of the Employee object
     *
     *@return The ssn value
     */
    public String getSsn() {
        return ssn;
    }

    /**
     *  Gets the department attribute of the Employee object
     *
     *@return The department value
     */
    public String getDepartment() {
        return department;
    }

    /**
     *  Gets the roomNumber attribute of the Employee object
     *
     *@return The roomNumber value
     */
    public String getRoomNumber() {
        return roomNumber;
    }


    /**
     *  Gets the phoneNumber attribute of the Employee object
     *
     *@return The phoneNumber value
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


/******************************************************************************/

    /**
     *  Sets the employeeID attribute of the Employee object
     *
     *@param employeeID  The new employeeID value
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     *  Sets the firstName attribute of the Employee object
     *
     *@param firstName  The new firstName value
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *  Sets the lastName attribute of the Employee object
     *
     *@param lastName  The new lastName value
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *  Sets the ssn attribute of the Employee object
     *
     *@param ssn  The new ssn value
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     *  Sets the department attribute of the Employee object
     *
     *@param department  The new department value
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *  Sets the roomNumber attribute of the Employee object
     *
     *@param roomNumber  The new roomNumber value
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    /**
     *  Sets the phoneNumber attribute of the Employee object
     *
     *@param phoneNumber  The new phoneNumber value
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

/******************************************************************************/

    /**
     *  Used to print the Employee attributes of the Employee object
     *
     */
    public String toString() {

        String employeeInfo =
                "Employee ID: " + this.getEmployeeID( )+" | "+
                        "Employee First Name: " + this.getFirstName()+" | "+
                        "Employee Last Name: " + this.getLastName()+" | "+
                        "Employee Social Security Number: " + this.getSsn()+" | "+
                        "Employee Department: " + this.getDepartment()+" | "+
                        "Employee Room Number: " + this.getRoomNumber()+" | "+
                        "Employee Phone Number: " + this.getPhoneNumber() ;

        return employeeInfo;
    }

    /**
     *  Used to print the Employee attributes of the Employee object as Tab Delimited record
     *
     */
    public String toTabDelimitedString() {

        String employeeTabDelimitedInfo =
                this.getEmployeeID() + "\t" +
                        this.getFirstName() + "\t" +
                        this.getLastName() + "\t" +
                        this.getSsn() + "\t" +
                        this.getDepartment() + "\t" +
                        this.getRoomNumber() + "\t" +
                        this.getPhoneNumber() ;

        return employeeTabDelimitedInfo;
    }


}

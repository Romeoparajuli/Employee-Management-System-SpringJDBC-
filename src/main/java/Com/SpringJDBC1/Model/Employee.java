package Com.SpringJDBC1.Model;

public class Employee {
    
    // Declaring member variables for the Employee class
    private int id;              // Employee ID
    private String nameString;   // Employee name
    private String emailString;  // Employee email
    private String addressString;// Employee address
    private String departmentString; // Department where the employee works
    private int contactnumber;   // Employee's contact number
    private double salary;       // Employee's salary
    private String postString;   // Post/Designation of the employee

    // Getter and setter methods for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getEmailString() {
        return emailString;
    }

    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getDepartmentString() {
        return departmentString;
    }

    public void setDepartmentString(String departmentString) {
        this.departmentString = departmentString;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPostString() {
        return postString;
    }

    public void setPostString(String postString) {
        this.postString = postString;
    }

    // Overriding the toString method to provide a meaningful string representation of an Employee object
    @Override
    public String toString() {
        return "Employee [id=" + id + ", nameString=" + nameString + ", emailString=" + emailString + ", addressString="
                + addressString + ", departmentString=" + departmentString + ", contactnumber=" + contactnumber
                + ", salary=" + salary + ", postString=" + postString + "]";
    }
}

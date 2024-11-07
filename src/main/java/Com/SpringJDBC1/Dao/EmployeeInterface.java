package Com.SpringJDBC1.Dao;

import java.util.List;

import Com.SpringJDBC1.Model.Employee;

public interface EmployeeInterface {

    /**
     * This method is used to save a new Employee record in the database.
     * 
     * @param employee The Employee object containing the details to be saved.
     * @return An integer indicating the result of the operation. 
     *         It usually returns the number of rows affected in the database (1 if successful).
     */
    int save(Employee employee);

    /**
     * This method is used to update an existing Employee record in the database.
     * 
     * @param employee The Employee object containing the updated details to be saved.
     * @return An integer indicating the result of the operation. 
     *         It usually returns the number of rows affected in the database (1 if successful).
     */
    int update(Employee employee);

    /**
     * This method is used to delete an Employee record from the database by its ID.
     * 
     * @param id The ID of the Employee to be deleted.
     * @return An integer indicating the result of the operation. 
     *         It usually returns the number of rows affected in the database (1 if successful).
     */
    int delete(int id);

    /**
     * This method is used to retrieve a specific Employee record from the database by its ID.
     * 
     * @param id The ID of the Employee to be retrieved.
     * @return The Employee object containing the details of the Employee with the given ID.
     */
    Employee getEmployee(int id);

    /**
     * This method is used to retrieve all Employee records from the database.
     * 
     * @return A List of Employee objects containing the details of all Employees in the database.
     */
    List<Employee> getAllEmployees();

    /**
     * This method is used to search for Employee records based on a search key.
     * The search is performed on various fields like name, email, address, etc.
     * 
     * @param keyString The search term that will be used to find Employees.
     * @return A List of Employee objects containing the details of Employees that match the search term.
     */
    List<Employee> searchEmployees(String keyString);

    /**
     * This method is used to retrieve Employee records by pagination.
     * 
     * @param pageNumber The page number to retrieve.
     * @param pageSize The number of records to retrieve per page.
     * @return A List of Employee objects containing the details of Employees for the specified page.
     */
    List<Employee> getEmployeesByPage(int pageNumber, int pageSize);
    int getTotalEmployeeCount();
}

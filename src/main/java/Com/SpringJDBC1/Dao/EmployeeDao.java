package Com.SpringJDBC1.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Com.SpringJDBC1.Model.Employee;

public class EmployeeDao implements EmployeeInterface {

	// JdbcTemplate object to interact with the database
	JdbcTemplate jdbcTemplate;

	// Setter method to initialize the JdbcTemplate object
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Saves an Employee object into the database.
	 * 
	 * @param employee The Employee object to be saved
	 * @return The number of rows affected by the query (1 if successful)
	 */
	@Override
	public int save(Employee employee) {
		// SQL query to insert a new employee into the employee table
		String insertString = " insert into employee( nameString ,emailString,address,departmentString,contactNumber,salary,postString) values (?,?,?,?,?,?,?)";

		// Execute the insert query with the Employee object properties
		return jdbcTemplate.update(insertString, employee.getNameString(), employee.getEmailString(),
				employee.getAddressString(), employee.getDepartmentString(), employee.getContactnumber(),
				employee.getSalary(), employee.getPostString());
	}

	/**
	 * Updates an existing Employee's details in the database.
	 * 
	 * @param employee The Employee object with updated data
	 * @return The number of rows affected by the update query (1 if successful)
	 */
	@Override
	public int update(Employee employee) {
		// SQL query to update an existing employee's details based on their ID
		String updateString = "UPDATE employee SET nameString = ?, emailString = ?, address = ?, departmentString = ?, contactNumber = ?, salary = ?, postString = ? WHERE id = ?";

		// Execute the update query with the Employee object properties and the employee
		// ID
		return jdbcTemplate.update(updateString, employee.getNameString(), employee.getEmailString(),
				employee.getAddressString(), employee.getDepartmentString(), employee.getContactnumber(),
				employee.getSalary(), employee.getPostString(), employee.getId());
	}

	/**
	 * Deletes an Employee from the database using their ID.
	 * 
	 * @param id The ID of the employee to be deleted
	 * @return The number of rows affected by the delete query (1 if successful)
	 */
	@Override
	public int delete(int id) {
		// SQL query to delete an employee based on their ID
		String deleteString = "delete from employee where id= ?";

		// Execute the delete query with the employee ID
		return jdbcTemplate.update(deleteString, id);
	}

	/**
	 * Retrieves a single Employee's details from the database using their ID.
	 * 
	 * @param id The ID of the employee to be retrieved
	 * @return The Employee object with the corresponding ID
	 */
	@Override
	public Employee getEmployee(int id) {
		// SQL query to retrieve an employee's details based on their ID
		String selectString = " select * from employee where id=?";

		// RowMapper implementation to map the result set to an Employee object
		RowMapperImpl reImpl = new RowMapperImpl();

		// Execute the query and return the mapped Employee object
		return jdbcTemplate.queryForObject(selectString, reImpl, id);
	}

	/**
	 * Retrieves all Employees from the database.
	 * 
	 * @return A List of all Employee objects in the database
	 */
	@Override
	public List<Employee> getAllEmployees() {
		// SQL query to retrieve all employees from the employee table
		String allString = "SELECT * from employee";

		// RowMapper implementation to map the result set to Employee objects
		RowMapperImpl impl = new RowMapperImpl();

		// Execute the query and return a list of all Employee objects
		return jdbcTemplate.query(allString, impl);
	}

	/**
	 * Searches for employees whose details match the search keyword.
	 * 
	 * @param keyString The search keyword to filter employees by name, email,
	 *                  address, etc.
	 * @return A List of Employee objects that match the search criteria
	 */
	@Override
	public List<Employee> searchEmployees(String keyString) {
		// SQL query to search for employees matching the search keyword in any column
		String searchQuery = "SELECT * FROM employee WHERE  nameString LIKE ? OR emailString LIKE? OR  address LIKE ? OR departmentString LIKE ? OR contactNumber  LIKE ? OR  salary LIKE ? OR postString LIKE ?";

		// Creating a string for the search term with "%" wildcards
		String searchString = "%" + keyString + "%";

		// RowMapper implementation to map the result set to Employee objects
		RowMapperImpl rowMapperImpl = new RowMapperImpl();

		// Execute the query and return a list of matching Employee objects
		return jdbcTemplate.query(searchQuery, rowMapperImpl, searchString, searchString, searchString, searchString,
				searchString, searchString, searchString);
	}

	/**
	 * Retrieves a paginated list of Employees from the database.
	 * 
	 * @param pageNumber The page number to retrieve (e.g., 1 for the first page)
	 * @param pageSize   The number of employees to display per page
	 * @return A List of Employee objects for the specified page
	 */
	@Override
	public List<Employee> getEmployeesByPage(int pageNumber, int pageSize) {
		// Calculate the offset (the starting index of the records to fetch)
		int offset = (pageNumber - 1) * pageSize;

		// SQL query to retrieve a subset of employees based on the page size and offset
		String queryString = "SELECT * FROM employee LIMIT ? OFFSET ?";

		// RowMapper implementation to map the result set to Employee objects
		RowMapperImpl impl = new RowMapperImpl();

		// Execute the query with the pageSize and offset as parameters
		return jdbcTemplate.query(queryString, impl, pageSize, offset);
	}

	@Override
	public int getTotalEmployeeCount() {
		String countString = "SELECT COUNT( * )FROM employee ";

		return jdbcTemplate.queryForObject(countString, Integer.class);
	}

}

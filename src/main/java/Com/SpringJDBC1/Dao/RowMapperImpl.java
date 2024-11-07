package Com.SpringJDBC1.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Com.SpringJDBC1.Model.Employee;

public class RowMapperImpl implements RowMapper<Employee> {

    /**
     * This method maps a row from the ResultSet to an Employee object.
     * It is used by the JdbcTemplate to convert each row of the query result into an Employee object.
     * 
     * @param rs The ResultSet that contains the data from the database
     * @param arg1 The row number in the ResultSet (not used in this case)
     * @return An Employee object with data mapped from the current row in the ResultSet
     * @throws SQLException If there is an error accessing the data from the ResultSet
     */
    @Override
    public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
        // Creating a new Employee object to store the data from the current row
        Employee employee = new Employee();
        
        // Mapping the result set columns to the corresponding fields of the Employee object
        employee.setId(rs.getInt("id")); // Maps the 'id' column from the ResultSet to the Employee's 'id' field
        employee.setNameString(rs.getString("nameString")); // Maps the 'nameString' column to 'nameString' field
        employee.setEmailString(rs.getString("emailString")); // Maps the 'emailString' column to 'emailString' field
        employee.setAddressString(rs.getString("address")); // Maps the 'address' column to 'addressString' field
        employee.setDepartmentString(rs.getString("departmentString")); // Maps the 'departmentString' column to 'departmentString' field
        employee.setContactnumber(rs.getInt("contactNumber")); // Maps the 'contactNumber' column to 'contactnumber' field
        employee.setPostString(rs.getString("postString")); // Maps the 'postString' column to 'postString' field
        employee.setSalary(rs.getDouble("salary")); // Maps the 'salary' column to 'salary' field

        // Returning the mapped Employee object
        return employee;
    }
}

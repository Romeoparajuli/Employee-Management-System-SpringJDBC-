package Com.SpringJDBC1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Com.SpringJDBC1.Dao.EmployeeDao;
import Com.SpringJDBC1.Model.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!\nWelcome");

		// Load the Spring context
		ApplicationContext context = new ClassPathXmlApplicationContext(" Com/SpringJDBC1/resources/config.xml");

		// Retrieve the EmployeeDao bean
		EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);

		// Create an Employee object and set properties
		Employee employee = new Employee();
//		employee.setId(4);
//		employee.setNameString("Subam parajuli");
//		employee.setEmailString("Subam_Parajuli`1@gmail.com");
//		employee.setAddressString("tilotama");
//		employee.setContactnumber(11010122); // Ensure this is set as an integer or long in Employee
//		employee.setDepartmentString("frontDext");
//
//		employee.setSalary(22000);
//		employee.setPostString(" Intern");
//
//		// Attempt to save the employee
//		int insert = dao.save(employee);
//		if (insert > 0)
//			System.out.println("Data insertion successful!");
//		else
//			System.err.println("Data insertion unsuccessful!");

/////////////// Attempt to  update //////////
//	int update = dao.update(employee);
//	if(update > 0) System.out.println("** Update is Sucessfull**");
//	else System.err.println("** Update is Unsucessfull**");

/////////////// Attempt to  delete //////////
//		int delet = dao.delete(6);
//		if(delet>0)System.out.println("SucessFully Deleted");
//		else System.err.println("Delete Unsucessfull"); 
//		
/////////////// Attempt to Get by id  ////////// 

//		Employee getByid= dao.getEmployee(7);
//		System.out.println(getByid);

/////////////// Attempt to  Get list of all employe   ////////// 
//		 List<Employee> allEmployees = dao.getAllEmployees();
//		 for (Employee emp : allEmployees)System.out.println(emp);

/////////////// Attempt to  Get list of all employe by keywords   ////////// 

		// Search for employees with a keyword (e.g., "InfoTech")
//		String keyString = "tilotama";
//		List<Employee> employees = dao.searchEmployees(keyString);
//
//		// Displaying the search result
//
//		if (employee != null && !employees.isEmpty())
//			for (Employee employee2 : employees)
//				System.err.println(employee2);
//		else
//			System.err.println("** No employees found matching the keyword. **");

/////////////// Attempt to  Get list of all employe with pagination    ////////// 
		 // lets define page number and size 
//		int pageNumber= 1;// for example first page 
//		int pageSixe=9;// for example 5 record per page 
//		// getting  paginated employees 
//		
//		List<Employee>eList=dao.getEmployeesByPage(pageNumber, pageSixe);
//		//Displaying the data 
//		if(eList!=null&&!eList.isEmpty())
//			for (Employee employee2 : eList) 
//				System.out.println(employee2);
//		else 
//			System.err.println("** No employees found for this page. **");
//				
			
		int totalEmployees = dao.getTotalEmployeeCount();
		System.out.println(" the total number of employees are "+ totalEmployees);
		
	}
}

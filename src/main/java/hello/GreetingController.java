
package hello;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	    private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping("/greeting")
	    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        return new Greeting(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	    
	   /* @RequestMapping("/updtaeemployer")
	    public EmployeeDTO employerDetails() {
	        //return new EmployeeDTO("santhi", "stevenson blvd", 1);
	        
	        //hibernateconnection \\call any static method for connection
	        //create Emplyee entity and test insert data
	    }
	    */
	    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
	       EmployeeDAO employeeDAO=new EmployeeDAO();
	       employeeDAO.createEmployee(employee);
	    	
	      return new ResponseEntity<EmployeeDTO>(employee, HttpStatus.OK);
	    	
	    }
	    
	    
	    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	    public ResponseEntity<EmployeeDTO> getEmployee(@RequestParam(value="employeeID") int employeeID) {
		       EmployeeDAO employeeDAO=new EmployeeDAO();
		       EmployeeDTO employeeDTO=employeeDAO.getEmployee(employeeID);
		    	
		      return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
		}
	    
	    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee,@RequestParam(value="employeeID") int employeeID) {
		       EmployeeDAO employeeDAO=new EmployeeDAO();
		       employeeDAO.updateEmployee(employee,employeeID);
		    	
		      return new ResponseEntity<EmployeeDTO>(employee, HttpStatus.OK);
		}
	    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	    public ResponseEntity<EmployeeDTO> deleteEmployee(@RequestParam(value="employeeID") int employeeID) {
		       EmployeeDAO employeeDAO=new EmployeeDAO();
		       EmployeeDTO employeeDTO=employeeDAO.deleteEmployee(employeeID);
		    	
		      return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
		}
	    
	    
	    @RequestMapping("/employee")
	    public static void getEmployeeTableDetails() {
	    	ServiceRegistry serviceRegistry;
			SessionFactory sessionFactory;

	      Employee emp=new Employee();
	     //emp.setId(1);
	      emp.setFirstName("Anand");
	      emp.setLastName("mogalapu");
	      emp.setSalary(300);
	      //System.out.println(emp.getFirstName());
	      //System.out.println(emp.getId());
	      Configuration configuration = new Configuration();
	      configuration.configure();
	      serviceRegistry = new ServiceRegistryBuilder().applySettings(
	              configuration.getProperties()). buildServiceRegistry();
	      sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	      System.out.println(emp.getId());
	      System.out.print("testing the table!");
	      Session session=sessionFactory.openSession();
	      session.beginTransaction();
	      session.save(emp);
	      session.getTransaction().commit();
	     
	    	
	        //return new Employee();
	    }
	    //delete records
	    @RequestMapping("/deleteemployee")
	    public static void deleteEmployee(Integer Employeeid)
	    {
	    	ServiceRegistry serviceRegistry;
			SessionFactory sessionFactory;
			Employee emp=new Employee();
			Configuration configuration = new Configuration();
		      configuration.configure();
		      serviceRegistry = new ServiceRegistryBuilder().applySettings(
		              configuration.getProperties()). buildServiceRegistry();
		      sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
		      Session session=sessionFactory.openSession();
		      session.beginTransaction();
		      Employee employee = 
	                   (Employee)session.get(Employee.class, 40); 
	         session.delete(employee); 
		      
		      //session.save(emp);
		      session.getTransaction().commit();
		    	
		    	

	    	
	    }
	       
	    }
	
	


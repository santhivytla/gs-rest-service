package hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EmployeeDAO {
	public void createEmployee(EmployeeDTO employee)
	{
		
	Employee emp=new Employee();
    //emp.setId(1);
     emp.setFirstName(employee.getEmpFirstName());
     emp.setLastName(employee.getEmpLastName());
     emp.setSalary(employee.getSalary());
     System.out.println(emp.getId());
     System.out.print("testing the table!");
     Session session=getSession();
     session.beginTransaction();
     session.save(emp);
     session.getTransaction().commit();
	}
	public EmployeeDTO getEmployee(int employeeID)
	{
		
	EmployeeDTO emp=new EmployeeDTO();
	 
     Session session=getSession();
     Employee dbEmployee = (Employee) session.get(Employee.class, employeeID);
     emp.setEmpFirstName(dbEmployee.getFirstName());
     emp.setEmpLastName(dbEmployee.getLastName());
     emp.setSalary(dbEmployee.getSalary());
      session.beginTransaction();
     
     session.getTransaction().commit();
     return emp;
	}
	public Employee updateEmployee(EmployeeDTO employee,int employeeID)
	{
		
	EmployeeDTO emp=new EmployeeDTO();
	 
     Session session=getSession();
   Employee dbEmployee = (Employee) session.get(Employee.class, employeeID);
     //dbEmployee.setFirstName("Abhi");
     //session.update(dbEmployee);
     dbEmployee.setFirstName(employee.getEmpFirstName());
     dbEmployee.setLastName(employee.getEmpLastName());
     dbEmployee.setSalary(employee.getSalary());
     session.update(dbEmployee);
      session.beginTransaction();
     
     session.getTransaction().commit();
     return dbEmployee;
	}
	public EmployeeDTO deleteEmployee(int employeeID)
	{
		
	EmployeeDTO emp=new EmployeeDTO();
	 
     Session session=getSession();
     Employee dbEmployee = (Employee) session.get(Employee.class, employeeID);
     session.delete(dbEmployee);
    
     
    // emp.setEmpFirstName(dbEmployee.getFirstName());
     //emp.setEmpLastName(dbEmployee.getLastName());
     //emp.setSalary(dbEmployee.getSalary());
      session.beginTransaction();
     
     session.getTransaction().commit();
     return emp;
	}
	
	
	
	
	
	
	
	public Session getSession()
	{
		ServiceRegistry serviceRegistry;
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
	     configuration.configure();
	     serviceRegistry = new ServiceRegistryBuilder().applySettings(
	             configuration.getProperties()). buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
		Session session=sessionFactory.openSession();
		return session;
		
	}

}

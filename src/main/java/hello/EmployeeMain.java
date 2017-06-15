package hello;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class EmployeeMain {

	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceRegistry serviceRegistry;
		SessionFactory sessionFactory;

      Employee emp=new Employee();
     //emp.setId(1);
      emp.setFirstName("xkkkasd");
      emp.setLastName("asdasdd");
      emp.setSalary(500);
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
	}
	*/

}

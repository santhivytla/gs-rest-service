package hello;

public class EmployeeDTO {
	private String empFirstName;
	private String empLastName;
	private int salary;
	
	public EmployeeDTO() {
		empFirstName="";
		empLastName="";
		salary=0;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	





}

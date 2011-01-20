package beanNameAware.src;

import org.springframework.beans.factory.InitializingBean;

public class EmployeeBean implements InitializingBean {
	private String name;
	private int age;
	private double salary;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void afterPropertiesSet() throws Exception {
		if(name == null || age == 0 || salary == 0){
			throw new Exception("Mandatory fields are not set in the EmployeeBean class");
		}
	}

}

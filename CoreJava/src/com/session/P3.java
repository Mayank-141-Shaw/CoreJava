package com.session;

public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project mobile = new Project(1, "Mobile App for Project Management", "Bangalore");
		Project web = new Project(2, "E-Commerce Web App", "Kolkata");
		
	
		Employee e[] = { new Employee(10, "MK", 100000, mobile),
				new Employee(20, "Naira", 30000, mobile),
				new Employee(30, "Simran", 26000, web),
				new Employee(40, "Rohan", 17000, web)
			};
		
		for(Employee emp : e) {
			if(emp.esal > 25000 && emp.project == web) {
				emp.display();
			}
		}
	}

}

class Project{
	int pid;
	String pname;
	String plocation;
	public Project(int pid, String pname, String plocation) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.plocation = plocation;
	}
	
}

class Employee{
	int eid;
	String ename;
	int esal;
	Project project;
	public Employee(int eid, String ename, int esal, Project project) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.project = project;
	}
	
	public void display() {
		System.out.println("Employee Id : "+this.eid+
						"\nEmployee name : "+this.ename+
						"\nEmployee Salary : "+this.esal+
						"\nProject ID : "+this.project.pid+
						"\nProject Name : "+this.project.pname+
						"\nProject Location : "+this.project.plocation+"\n");
	}
	
}
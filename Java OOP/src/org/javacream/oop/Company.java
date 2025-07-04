package org.javacream.oop;

import java.util.HashSet;

public class Company {
	private String name;
	private HashSet<Worker> employees;
	public Company(String name) {
		this.name = name;
		this.employees = new HashSet<>();
	}
	
	public void employ(Worker worker) {
		this.employees.add(worker);
	}
	
	public void quit(Worker worker) {
		this.employees.remove(worker);
		worker.setCompany(null);
		
	}

	public String getName() {
		return name;
	}
	
	public String companyInfo() {
		return "Company(name=" + name + ", employees=" + this.employees + ")";
	}
}
